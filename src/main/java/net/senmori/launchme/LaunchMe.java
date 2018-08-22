package net.senmori.launchme;

import net.senmori.launchme.managers.TargetManagerImpl;
import net.senmori.launchme.service.TargetManager;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.plugin.ApiVersion;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

@Plugin(name = "LaunchMe", version = "0.5")
@Author("Bitjump")
@Author("Senmori")
@ApiVersion(ApiVersion.Target.v1_13)
public class LaunchMe extends JavaPlugin {
    private static LaunchMe INSTANCE;

    private TargetManagerImpl targetManager;

    @Override
    public void onEnable() {
        INSTANCE = this;

        this.targetManager = new TargetManagerImpl();
        getServer().getServicesManager().register( TargetManager.class, targetManager, this, ServicePriority.Normal );

    }

    @Override
    public void onDisable() {

    }

    public static LaunchMe getInstance() {
        return INSTANCE;
    }

    public static NamespacedKey getDefaultKey() {
        return new NamespacedKey( "launchme", "null" );
    }

    public static NamespacedKey createKey(String key) {
        return new NamespacedKey( "launchme", key );
    }
}
