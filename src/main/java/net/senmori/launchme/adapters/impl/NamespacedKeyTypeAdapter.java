package net.senmori.launchme.adapters.impl;

import net.senmori.launchme.adapters.YamlTypeAdapter;
import net.senmori.launchme.transport.GameData;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public class NamespacedKeyTypeAdapter implements YamlTypeAdapter<NamespacedKey> {
    @SuppressWarnings("deprecation")
    @Override
    public NamespacedKey deserialize(ConfigurationSection section) {
        return GameData.checkKey( section.getName() );
    }

    @Override
    public boolean serialize(NamespacedKey value, FileConfiguration config) {
        ConfigurationSection section = config.createSection( toString( value ) );
        return section != null;
    }

    public String toString(NamespacedKey key) {
        return "\"" + key.toString() + "\"";
    }
}
