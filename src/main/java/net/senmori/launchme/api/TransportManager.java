package net.senmori.launchme.api;

import net.senmori.launchme.transport.Transport;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;

public interface TransportManager {

    Transport getTransport(NamespacedKey key);

    Transport getTransport(Location location);

    void registerTransport(Transport transport);


}
