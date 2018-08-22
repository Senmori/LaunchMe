package net.senmori.launchme.api.manager;

import net.senmori.launchme.api.Transport;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;

import java.util.Collection;

public interface TransportManager {

    Transport getTransport(NamespacedKey key);

    Transport getTransport(Location location);

    void registerTransport(Transport transport);

    Collection<Transport> getRegisteredTransports();
}
