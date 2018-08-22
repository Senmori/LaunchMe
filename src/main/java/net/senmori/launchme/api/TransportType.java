package net.senmori.launchme.api;

import net.senmori.launchme.LaunchMe;
import net.senmori.launchme.transport.method.TeleportTransportMethod;
import net.senmori.launchme.transport.options.DefaultTransportOptions;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;

import java.util.function.Supplier;

public final class TransportType implements Keyed {
    public static final TransportType TELEPORT = new TransportType( LaunchMe.createKey("teleport"), new TeleportTransportMethod());


    private final NamespacedKey name;
    private final TransportMethod transportMethod;
    private final TransportOptions defaultOptions;
    public TransportType(NamespacedKey name, TransportMethod methodSupplier, TransportOptions defaultOptions) {
        this.name = name;
        this.transportMethod = methodSupplier;
        this.defaultOptions = defaultOptions;
    }

    public TransportType(NamespacedKey name, TransportMethod supplier) {
        this(name, supplier, TransportType.defaultTransportOptions().get());
    }

    @Override
    public NamespacedKey getKey() {
        return name;
    }

    public TransportMethod getTransportMethod() {
        return transportMethod;
    }

    public TransportOptions getTransportOptions() {
        return defaultOptions;
    }

    public static Supplier<TransportMethod> defaultTransportMethod() {
        return TeleportTransportMethod::new;
    }

    public static Supplier<TransportOptions> defaultTransportOptions() {
        return DefaultTransportOptions::new;
    }
}
