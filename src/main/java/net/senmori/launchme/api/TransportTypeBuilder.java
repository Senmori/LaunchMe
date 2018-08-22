package net.senmori.launchme.api;

import org.bukkit.NamespacedKey;

public final class TransportTypeBuilder {

    private final NamespacedKey key;
    private TransportMethod method = TransportType.defaultTransportMethod().get();
    private TransportOptions options = TransportType.defaultTransportOptions().get();

    public TransportTypeBuilder(NamespacedKey key) {
        this.key = key;
    }

    public TransportTypeBuilder method(TransportMethod method) {
        this.method = method;
        return this;
    }

    public TransportTypeBuilder options(TransportOptions options) {
        this.options = options;
        return this;
    }

    public TransportType create() {
        return new TransportType(key, method, options);
    }
}
