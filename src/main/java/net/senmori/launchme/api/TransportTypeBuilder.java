package net.senmori.launchme.api;

import net.senmori.launchme.transport.GameData;
import net.senmori.launchme.transport.TransportMethod;
import net.senmori.launchme.transport.TransportOptions;
import net.senmori.launchme.transport.TransportType;
import org.bukkit.NamespacedKey;

import java.util.function.Supplier;

public final class TransportTypeBuilder {

    private final NamespacedKey key;
    private Supplier<TransportMethod> method = GameData::defaultTransportMethod;
    private Supplier<TransportOptions> options = GameData::defaultTransportOptions;

    public TransportTypeBuilder(NamespacedKey key) {
        this.key = key;
    }

    public TransportTypeBuilder method(Supplier<TransportMethod> method) {
        this.method = method;
        return this;
    }

    public TransportTypeBuilder options(Supplier<TransportOptions> options) {
        this.options = options;
        return this;
    }

    public TransportType create() {
        return new TransportType(key, method, options);
    }
}
