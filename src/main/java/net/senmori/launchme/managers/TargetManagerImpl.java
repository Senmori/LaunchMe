package net.senmori.launchme.managers;

import net.senmori.launchme.adapters.TargetTypeAdapter;
import net.senmori.launchme.targets.EmptyTarget;
import net.senmori.launchme.targets.Target;
import net.senmori.senlib.configuration.IConfigurationListener;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TargetManagerImpl implements IConfigurationListener {
    private static final TargetTypeAdapter DEFAULT_ADAPTER = new TargetTypeAdapter();

    private final Map<String, Target> targetMap = new HashMap<>();

    @Override
    public boolean onLoad(FileConfiguration config) {
        if (config.getKeys(false).isEmpty()) {
            return true; // no targets
        }

        Set<String> keys = config.getKeys(false);

        for (String key : keys) {
            if (config.isConfigurationSection(key)) {
                Target target = DEFAULT_ADAPTER.deserialize(config.getConfigurationSection(key));
                targetMap.put( target.getName(), target );
            }
        }
        return !targetMap.isEmpty();
    }

    @Override
    public boolean onSave(FileConfiguration config) {
        for (Target target : targetMap.values()) {
            DEFAULT_ADAPTER.serialize(target, config);
        }
        return targetMap.isEmpty() || !config.getKeys(false).isEmpty();
    }
}
