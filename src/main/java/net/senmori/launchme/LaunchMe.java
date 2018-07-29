package net.senmori.launchme;

import net.senmori.launchme.configuration.TargetConfiguration;
import net.senmori.launchme.managers.TargetManagerImpl;
import net.senmori.senlib.configuration.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.plugin.ApiVersion;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Plugin(name = "LaunchMe", version = "0.5")
@Author("Bitjump")
@Author("Senmori")
@ApiVersion(ApiVersion.Target.v1_13)
public class LaunchMe extends JavaPlugin {
    private static LaunchMe INSTANCE;

    private Map<String, ConfigManager> configurations = new HashMap<>();
    private TargetConfiguration targetConfiguration;

    private TargetManagerImpl targetManager;

    @Override
    public void onEnable() {
        INSTANCE = this;

        this.targetManager = new TargetManagerImpl();
        this.targetConfiguration = new TargetConfiguration( this, new File( this.getDataFolder(), "targets.yml" ) );
        this.targetConfiguration.addListener( targetManager );
        this.configurations.put( "targets", targetConfiguration );
        targetConfiguration.load();

    }

    @Override
    public void onDisable() {
        configurations.values().forEach( ConfigManager::save );
    }

    public static LaunchMe getInstance() {
        return INSTANCE;
    }
}
