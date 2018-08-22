package net.senmori.launchme.transport;

import net.senmori.launchme.transport.method.TeleportTransportMethod;
import net.senmori.launchme.transport.options.DefaultTransportOptions;

import java.util.function.Supplier;

public final class TransportType {
    public static final TransportType TELEPORT = new TransportType("teleport", TeleportTransportMethod::new);


    private final String name;
    private final Supplier<TransportMethod> transportMethodSupplier;
    private final Supplier<TransportOptions> defaultOptions;
    public TransportType(String name, Supplier<TransportMethod> methodSupplier, Supplier<TransportOptions> defaultOptions) {
        this.name = name;
        this.transportMethodSupplier = methodSupplier;
        this.defaultOptions = defaultOptions;
    }

    public TransportType(String name, Supplier<TransportMethod> supplier) {
        this(name, supplier, DefaultTransportOptions::new);
    }

    public String getName() {
        return name;
    }

    public TransportMethod getTransportMethod() {
        return transportMethodSupplier.get();
    }

    public TransportOptions getTransportOptions() {
        return defaultOptions.get();
    }
}
