package net.senmori.launchme.transport;

import net.senmori.launchme.LaunchMe;
import net.senmori.launchme.transport.method.TeleportTransportMethod;
import net.senmori.launchme.transport.options.DefaultTransportOptions;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;

import java.util.function.Supplier;

public final class TransportType implements Keyed {
    public static final TransportType TELEPORT = new TransportType( LaunchMe.createKey("teleport"), TeleportTransportMethod::new);


    private final NamespacedKey name;
    private final Supplier<TransportMethod> transportMethodSupplier;
    private final Supplier<TransportOptions> defaultOptions;
    public TransportType(NamespacedKey name, Supplier<TransportMethod> methodSupplier, Supplier<TransportOptions> defaultOptions) {
        this.name = name;
        this.transportMethodSupplier = methodSupplier;
        this.defaultOptions = defaultOptions;
    }

    public TransportType(NamespacedKey name, Supplier<TransportMethod> supplier) {
        this(name, supplier, DefaultTransportOptions::new);
    }

    @Override
    public NamespacedKey getKey() {
        return name;
    }

    public TransportMethod getTransportMethod() {
        return transportMethodSupplier.get();
    }

    public TransportOptions getTransportOptions() {
        return defaultOptions.get();
    }
}
