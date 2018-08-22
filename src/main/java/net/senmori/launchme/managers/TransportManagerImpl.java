package net.senmori.launchme.managers;

import net.senmori.launchme.service.TransportManager;
import net.senmori.launchme.transport.Transport;
import org.bukkit.NamespacedKey;

public class TransportManagerImpl implements TransportManager {
    @Override
    public boolean isRegistered(NamespacedKey name) {
        return false;
    }

    @Override
    public boolean registerTransport(Transport transport) {
        return false;
    }
}
