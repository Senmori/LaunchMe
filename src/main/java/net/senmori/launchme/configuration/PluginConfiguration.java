package net.senmori.launchme.configuration;

import net.senmori.senlib.configuration.DelegatingConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class PluginConfiguration extends DelegatingConfigManager {
    public PluginConfiguration(JavaPlugin plugin, File configFile) {
        super( plugin, configFile );
    }
}
