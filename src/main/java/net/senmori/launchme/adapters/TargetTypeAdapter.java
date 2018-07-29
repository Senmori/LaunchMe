package net.senmori.launchme.adapters;

import net.senmori.launchme.targets.BasicTarget;
import net.senmori.launchme.targets.EmptyTarget;
import net.senmori.launchme.targets.Target;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public class TargetTypeAdapter implements YamlTypeAdapter<Target> {
    @Override
    public Target deserialize(ConfigurationSection section) {
        if (section.getKeys(false).isEmpty()) {
            return new EmptyTarget();
        }
        String name = section.getName();
        Location location = section.getSerializable("location", Location.class);
        return new BasicTarget(name, location);
    }

    @Override
    public boolean serialize(Target value, FileConfiguration config) {
        ConfigurationSection section = config.createSection(value.getName());
        section.set("location", value.getLocation());
        return config.isConfigurationSection(value.getName());
    }
}
