package net.senmori.launchme.api;

import org.bukkit.Location;
import org.bukkit.NamespacedKey;

public interface TransportManager {

    Transport getTransport(NamespacedKey key);

    Transport getTransport(Location location);

    void registerTransport(Transport transport);


}
