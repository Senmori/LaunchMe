package net.senmori.launchme.registries;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Sets;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.stream.Stream;

public class LaunchMeRegistry<V extends Keyed> implements IRegistryModifiable<V> {

    private final BiMap<NamespacedKey, V> registry = HashBiMap.create();
    private boolean isLocked = false;

    @Override
    public void clear() {
        registry.keySet().forEach( this::remove );
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
    public @NotNull Collection<V> getValues() {
        return Sets.newHashSet(registry.values());
    }

    @Override
    public void register(@NotNull V value) {
        registry.put( value.getKey(), value );
    }

    @Override
    public void registerAll(@NotNull V... values) {
        Stream.of(values).forEach( this::register );
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
        return registry.remove( key );
    }

    @Override
    public boolean isLocked() {
        return isLocked;
    }
}
