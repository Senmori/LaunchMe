package net.senmori.launchme.adapters.impl;

import net.senmori.launchme.adapters.YamlTypeAdapter;
import net.senmori.launchme.targets.BasicTarget;
import net.senmori.launchme.api.Target;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public class TargetTypeAdapter implements YamlTypeAdapter<Target> {
    private static final NamespacedKeyTypeAdapter KEY_ADAPTER = new NamespacedKeyTypeAdapter();

    @Override
    public Target deserialize(ConfigurationSection section) {
        NamespacedKey key = KEY_ADAPTER.deserialize( section );
        Location location = section.getSerializable( "location", Location.class );
        return new BasicTarget( key, location );
    }

    @Override
    public boolean serialize(Target value, FileConfiguration config) {
        ConfigurationSection section = config.createSection( KEY_ADAPTER.toString( value.getKey() ) );
        section.set( "location", value.getLocation() );
        return config.isConfigurationSection( value.getKey().toString() );
    }
}
