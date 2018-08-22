package net.senmori.launchme.service;

import net.senmori.launchme.transport.Transport;
import org.bukkit.NamespacedKey;

public interface TransportManager {

    /**
     * Checks if an {@link Transport} already exists with the given name.
     *
     * @param name the name to check
     * @return true if not Transport exists with that name.
     */
    boolean isRegistered(NamespacedKey name);

    /**
     * Register a new {@link Transport}.
     *
     * @param transport the Transport to register
     * @return true if the Transport was successfully registered
     */
    boolean registerTransport(Transport transport);
}
