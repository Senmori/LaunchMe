package net.senmori.launchme.api;

import org.bukkit.NamespacedKey;

public interface TransportTypeManager {

    TransportType getTransportType(NamespacedKey key);

    void register(TransportType type);

    TransportTypeBuilder getBuilder(NamespacedKey key);
}
