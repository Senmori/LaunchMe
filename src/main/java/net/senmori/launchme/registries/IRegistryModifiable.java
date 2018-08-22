package net.senmori.launchme.registries;

import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;

public interface IRegistryModifiable<V extends Keyed> extends IRegistry<V> {

    void clear();

    V remove(NamespacedKey key);

    boolean isLocked();
}
