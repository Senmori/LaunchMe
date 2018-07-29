package net.senmori.launchme.managers;

import net.senmori.launchme.transport.ITransport;

public interface ITransportManager {

    /**
     * Checks if an {@link ITransport} already exists with the given name.
     *
     * @param name the name to check
     * @return true if not ITransport exists with that name.
     */
    boolean isRegistered(String name);

    /**
     * Register a new {@link ITransport}.
     *
     * @param transport the ITransport to register
     * @return true if the ITransport was successfully registered
     */
    boolean registerTransport(ITransport transport);
}
