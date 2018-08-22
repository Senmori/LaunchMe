package net.senmori.launchme.adapters.impl;

import net.senmori.launchme.adapters.YamlTypeAdapter;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public class NamespacedKeyTypeAdapter implements YamlTypeAdapter<NamespacedKey> {
    @SuppressWarnings( "deprecation" )
    @Override
    public NamespacedKey deserialize(ConfigurationSection section) {
        String key = section.getName();
        String[] split = key.split( ":", 1 );
        return new NamespacedKey( split[0], split[1] );
    }

    @Override
    public boolean serialize(NamespacedKey value, FileConfiguration config) {
        ConfigurationSection section = config.createSection( "\"" + value.toString() + "\"" );
        return section != null;
    }
}
