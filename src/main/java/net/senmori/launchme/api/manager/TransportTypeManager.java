package net.senmori.launchme.api.manager;

import net.senmori.launchme.api.TransportType;
import net.senmori.launchme.api.TransportTypeBuilder;
import org.bukkit.NamespacedKey;

import java.util.Collection;

public interface TransportTypeManager {

    TransportType getTransportType(NamespacedKey key);

    void registerTransportType(TransportType type);

    TransportTypeBuilder getBuilder(NamespacedKey key);

    Collection<TransportType> getRegisteredTypes();
}
