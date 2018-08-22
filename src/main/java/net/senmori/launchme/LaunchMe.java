package net.senmori.launchme;

import net.senmori.launchme.registries.IRegistry;
import net.senmori.launchme.registries.RegistryBuilder;
import net.senmori.launchme.registries.RegistryEventHandler;
import net.senmori.launchme.targets.Target;
import net.senmori.launchme.transport.Transport;
import net.senmori.launchme.transport.TransportMethod;
import org.bukkit.NamespacedKey;
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

    private final RegistryEventHandler eventHandler = new RegistryEventHandler();

    @Override
    public void onEnable() {
        INSTANCE = this;

        NamespacedKey targetKey = new NamespacedKey( this, "targets" );
        RegistryBuilder builder = new RegistryBuilder<>(this, targetKey, Target.class);
        builder.addCallback( eventHandler );
        TARGET_REGISTRY = builder.create();

        NamespacedKey transportKey = new NamespacedKey( this, "transports" );
        builder = new RegistryBuilder( this, transportKey, Transport.class );
        builder.addCallback( eventHandler );
        TRANSPORT_REGISTRY = builder.create();

        NamespacedKey methodKey = new NamespacedKey( this, "transportMethods" );
        builder = new RegistryBuilder( this, methodKey, TransportMethod.class );
        builder.addCallback( eventHandler );
        TRANSPORT_METHOD_REGISTRY = builder.create();
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
