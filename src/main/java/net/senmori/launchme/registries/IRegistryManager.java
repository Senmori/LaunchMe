package net.senmori.launchme.registries;

import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;

public interface IRegistryManager {

    String getName();

    <V extends Keyed> Class<V> getSuperType(NamespacedKey key);

    <V extends Keyed> NamespacedKey getName(IRegistry<V> registry);

    <V extends Keyed> IRegistry<V> getRegistry(NamespacedKey key);
}
