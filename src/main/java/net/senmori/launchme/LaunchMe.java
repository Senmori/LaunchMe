package net.senmori.launchme;

import net.senmori.launchme.api.*;
import net.senmori.launchme.managers.DefaultManager;
import net.senmori.launchme.registries.IRegistry;
import net.senmori.launchme.registries.RegistryEventHandler;
import net.senmori.launchme.transport.*;
import org.bukkit.Bukkit;
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

    private IRegistry<Target> TARGET_REGISTRY;
    private IRegistry<Transport> TRANSPORT_REGISTRY;
    private IRegistry<TransportMethod> TRANSPORT_METHOD_REGISTRY;
    private IRegistry<TransportType> TRANSPORT_TYPE_REGISTRY;
    private IRegistry<TransportOptions> TRANSPORT_OPTIONS_REGISTRY;

    private final RegistryEventHandler eventHandler = new RegistryEventHandler();
    private DefaultManager apiManager;

    @Override
    public void onLoad() {
        INSTANCE = this;

        TARGET_REGISTRY = GameData.makeRegistry( this, GameData.TARGETS, Target.class).addCallback( eventHandler ).create();
        TRANSPORT_REGISTRY = GameData.makeRegistry( this, GameData.TRANSPORTS, Transport.class ).addCallback( eventHandler ).create();
        TRANSPORT_METHOD_REGISTRY = GameData.makeRegistry( this, GameData.TRANSPORT_METHODS, TransportMethod.class ).addCallback( eventHandler ).create();
        TRANSPORT_TYPE_REGISTRY = GameData.makeRegistry( this, GameData.TRANSPORT_TYPES, TransportType.class ).addCallback( eventHandler ).create();
        TRANSPORT_OPTIONS_REGISTRY = GameData.makeRegistry( this, GameData.TRANSPORT_OPTIONS, TransportOptions.class ).addCallback( eventHandler ).create();

        this.apiManager = new DefaultManager( this );

        Bukkit.getServicesManager().register( TargetManager.class, apiManager, this, ServicePriority.Normal );
        Bukkit.getServicesManager().register( TransportManager.class, apiManager, this, ServicePriority.Normal );
        Bukkit.getServicesManager().register( TransportMethodManager.class, apiManager, this, ServicePriority.Normal );
        Bukkit.getServicesManager().register( TransportOptionsManager.class, apiManager, this, ServicePriority.Normal );
        Bukkit.getServicesManager().register( TransportTypeManager.class, apiManager, this, ServicePriority.Normal );
        Bukkit.getServicesManager().register( LaunchMeAPI.class, apiManager, this, ServicePriority.Normal );
    }

    @Override
    public void onEnable() {

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
        return GameData.checkKey( key );
    }
}
