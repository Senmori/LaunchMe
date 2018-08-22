package net.senmori.launchme.api;

import net.senmori.launchme.transport.TransportType;
import org.bukkit.NamespacedKey;

public interface TransportTypeFactory {

    TransportType getTransportType(NamespacedKey key);

    void register(TransportType type);

    TransportTypeBuilder getBuilder(NamespacedKey key);
}
