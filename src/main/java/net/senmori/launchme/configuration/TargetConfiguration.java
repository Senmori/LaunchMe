package net.senmori.launchme.configuration;

import net.senmori.senlib.configuration.DelegatingConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class TargetConfiguration extends DelegatingConfigManager {

    public TargetConfiguration(JavaPlugin plugin, File configFile) {
        super(plugin, configFile);
    }
}
