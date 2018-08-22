package net.senmori.launchme.registries;

import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;

import java.util.HashSet;
import java.util.Set;

public class RegistryBuilder<V extends Keyed> {

    private NamespacedKey name;
    private Class<V> type;
    private Plugin owner;
    private Set<IRegistry.AddCallback<V>> addCallbacks = new HashSet<>();
    private Set<IRegistry.RemoveCallback<V>> removeCallbacks = new HashSet<>();
    private Set<IRegistry.ClearCallback<V>> clearCallbacks = new HashSet<>();
    private Set<IRegistry.CreateCallback<V>> createCallbacks = new HashSet<>();

    public RegistryBuilder(Plugin owner, NamespacedKey key, Class<V> type) {
        this.owner = owner;
        this.name = key;
        this.type = type;
    }

    public RegistryBuilder<V> addCallback(Object obj) {
        if (obj instanceof IRegistry.AddCallback )
            add( ( IRegistry.AddCallback<V> ) obj );
        if (obj instanceof IRegistry.RemoveCallback )
            add( ( IRegistry.RemoveCallback<V> ) obj );
        if (obj instanceof IRegistry.ClearCallback )
            add( ( IRegistry.ClearCallback<V> ) obj );
        if (obj instanceof IRegistry.CreateCallback )
            add( ( IRegistry.CreateCallback<V> ) obj );
        return this;
    }

    public RegistryBuilder<V> add(IRegistry.AddCallback<V> callback) {
         this.addCallbacks.add( callback );
         return this;
    }

    public RegistryBuilder<V> add(IRegistry.RemoveCallback<V> callback) {
        this.removeCallbacks.add( callback );
        return this;
    }

    public RegistryBuilder<V> add(IRegistry.ClearCallback<V> callback) {
        this.clearCallbacks.add( callback );
        return this;
    }

    public RegistryBuilder<V> add(IRegistry.CreateCallback<V> callback) {
        this.createCallbacks.add( callback );
        return this;
    }

    public IRegistry<V> create() {
        return RegistryManager.ACTIVE.createRegistry( name, type, owner, addCallbacks, removeCallbacks, clearCallbacks, createCallbacks);
    }
}
