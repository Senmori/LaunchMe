package net.senmori.launchme.adapters;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public interface YamlTypeAdapter<T> extends TypeAdapter<ConfigurationSection, T> {

    @Override
    T deserialize(ConfigurationSection section);

    @Override
    boolean serialize(T value, FileConfiguration config);
}
