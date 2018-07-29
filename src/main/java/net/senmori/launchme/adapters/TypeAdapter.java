package net.senmori.launchme.adapters;

import org.bukkit.configuration.file.FileConfiguration;

public interface TypeAdapter<K, V> {

    V deserialize(K key);

    boolean serialize(V value, FileConfiguration configuration);
}
