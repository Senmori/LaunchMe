package net.senmori.launchme.registries;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import net.senmori.launchme.LaunchMe;
import org.apiguardian.api.API;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/*
 * Credit to MinecraftForge for this class.
 */
@API( status = API.Status.INTERNAL )
public class RegistryManager implements IRegistryManager {

    public static final RegistryManager ACTIVE = new RegistryManager( "ACTIVE" );

    private final BiMap<NamespacedKey, IRegistry<? extends Keyed>> registries = HashBiMap.create();
    private final BiMap<Class<? extends Keyed>, NamespacedKey> superTypes = HashBiMap.create();
    private final String name;

    public RegistryManager(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @SuppressWarnings( "unchecked" )
    public <V extends Keyed> Class<V> getSuperType(NamespacedKey key) {
        return ( Class<V> ) superTypes.inverse().get( key );
    }

    public <V extends Keyed> NamespacedKey getName(IRegistry<V> registry) {
        return registries.inverse().get( registry );
    }

    @SuppressWarnings("unchecked")
    public <V extends Keyed> IRegistry<V> getRegistry(NamespacedKey key) {
        return ( IRegistry<V> ) registries.get( key );
    }

    public <V extends Keyed> IRegistry<V> createRegistry(NamespacedKey key, Class<V> type, Plugin owner) {
        return createRegistry( key, type, owner, Lists.newArrayList(), Lists.newArrayList(), Lists.newArrayList(), Lists.newArrayList() );
    }

    public <V extends Keyed> IRegistry<V> createRegistry(NamespacedKey key, Class<V> type, Plugin owner,
                                                         Collection<IRegistry.AddCallback<V>> addCallbacks,
                                                         Collection<IRegistry.RemoveCallback<V>> removeCallbacks,
                                                         Collection<IRegistry.ClearCallback<V>> clearCallbacks,
                                                         Collection<IRegistry.CreateCallback<V>> createCallbacks) {
        Set<Class<?>> parents = new HashSet<>();
        findSuperTypes(type, parents);
        Sets.SetView<Class<?>> overlappedTypes = Sets.intersection( parents, superTypes.keySet() );

        if (!overlappedTypes.isEmpty()) {
            Class<?> foundType = overlappedTypes.iterator().next();
            String errorMsg = String.format( "Found existing registry of type '%s' named '%s'", foundType, superTypes.get( foundType ));
            LaunchMe.getInstance().getLogger().severe( errorMsg );
            throw new IllegalArgumentException( "Duplicate registry parent type found - you can only have on registry for a particular super type" );
        }
        IRegistry<V> registry = new LaunchMeRegistry<>( key, type, owner, addCallbacks, removeCallbacks, clearCallbacks, createCallbacks );
        registries.put( key, registry );
        superTypes.put( type, key );

        createCallbacks.forEach( (callack) -> callack.onCreate( registry ) );
        return getRegistry( key );
    }

    private void findSuperTypes(Class<?> type, Set<Class<?>> types) {
        if (type == null || type == Object.class) {
            return;
        }
        types.add(type);
        for (Class<?> interfac : type.getInterfaces()) {
            findSuperTypes(interfac, types);
        }
        findSuperTypes(type.getSuperclass(), types);
    }
}
