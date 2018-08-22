package net.senmori.launchme.service;

import net.senmori.launchme.transport.Transport;
import org.bukkit.NamespacedKey;

public interface TransportManager {

    Transport getTransport(NamespacedKey key);

    boolean registerTransport(Transport transport);


}
