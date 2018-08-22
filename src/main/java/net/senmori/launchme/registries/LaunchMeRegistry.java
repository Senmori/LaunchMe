package net.senmori.launchme.registries;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Stream;

public class LaunchMeRegistry<V extends Keyed> implements IRegistryModifiable<V> {

    private final BiMap<NamespacedKey, V> registry = HashBiMap.create();
    private final Plugin owner;
    private final NamespacedKey key;
    private final Class<V> type;
    private final Collection<IRegistry.AddCallback<V>> addCallbacks = new HashSet<>();
    private final Collection<IRegistry.RemoveCallback<V>> removeCallbacks = new HashSet<>();
    private final Collection<IRegistry.ClearCallback<V>> clearCallbacks = new HashSet<>();
    private final Collection<IRegistry.CreateCallback<V>> createCallbacks = new HashSet<>();

    LaunchMeRegistry(NamespacedKey key, Class<V> type, Plugin owner,
                            Collection<IRegistry.AddCallback<V>> addCallbacks,
                            Collection<IRegistry.RemoveCallback<V>> removeCallbacks,
                            Collection<IRegistry.ClearCallback<V>> clearCallbacks,
                            Collection<IRegistry.CreateCallback<V>> createCallbacks)
    {
        this.key = key;
        this.type = type;
        this.owner = owner;
        this.addCallbacks.addAll( addCallbacks );
        this.removeCallbacks.addAll( removeCallbacks );
        this.clearCallbacks.addAll( clearCallbacks );
        this.createCallbacks.addAll( createCallbacks );
    }

    @Override
    public NamespacedKey getKey() {
        return key;
    }

    @Override
    public Plugin getOwner() {
        return owner;
    }

    @Override
    public Class<V> getSuperType() {
        return type;
    }

    @Override
    public void clear() {
        registry.keySet().forEach( this::remove );
        clearCallbacks.forEach( (callback) -> callback.onClear( this ) );
    }

    @Nullable
    @Override
    public V getValue(NamespacedKey key) {
        return registry.get( key );
    }

    @Override
    public @Nullable NamespacedKey getKey(V value) {
        return registry.inverse().get( value );
    }

    @Override
    public void register(@NotNull V value) {
        V old = registry.get( value.getKey() );
        registry.put( value.getKey(), value );
        addCallbacks.forEach( (callback) -> callback.onAdd( this, value, old ) );
    }

    @Override
    public void registerAll(@NotNull V... values) {
        Stream.of( values ).forEach( this::register );
    }

    @Override
    public boolean containsKey(NamespacedKey key) {
        return registry.containsKey( key );
    }

    @Override
    public boolean containsValue(V value) {
        return registry.inverse().containsKey( value );
    }

    @Override
    public V remove(NamespacedKey key) {
        V toRemove = registry.get( key );
        removeCallbacks.forEach( (callback) -> callback.onRemove( this, toRemove ) );
        return registry.remove( key );
    }

    @Override
    public @NotNull Collection<V> getValues() {
        return Collections.unmodifiableSet( this.registry.values() );
    }

    @Override
    public Collection<Map.Entry<NamespacedKey, V>> getEntries() {
        return Collections.unmodifiableSet( this.registry.entrySet() );
    }

    @Override
    public boolean isLocked() {
        return false;
    }
}
