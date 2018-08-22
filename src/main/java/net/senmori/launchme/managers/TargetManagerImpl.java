package net.senmori.launchme.managers;

import net.senmori.launchme.adapters.impl.TargetTypeAdapter;
import net.senmori.launchme.service.TargetManager;
import net.senmori.launchme.targets.Target;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TargetManagerImpl implements TargetManager {
    private static final TargetTypeAdapter DEFAULT_ADAPTER = new TargetTypeAdapter();

    private final Map<NamespacedKey, Target> targetMap = new HashMap<>();

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

    public boolean onSave(FileConfiguration config) {
        for (Target target : targetMap.values()) {
            DEFAULT_ADAPTER.serialize(target, config);
        }
        return targetMap.isEmpty() || !config.getKeys(false).isEmpty();
    }

    @Override
    public boolean isRegistered(NamespacedKey name) {
        return targetMap.containsKey( name );
    }

    @Override
    public boolean registerTarget(Target target) {
        return targetMap.put( target.getName(), target ) == null;
    }

    @Override
    public Target getTarget(NamespacedKey name) {
        return targetMap.get( name );
    }

    @Override
    public boolean removeTarget(NamespacedKey name) {
        return targetMap.remove( name ) != null;
    }

    @Override
    public boolean removeTarget(Target target) {
        return targetMap.remove( target.getName(), target );
    }
}
