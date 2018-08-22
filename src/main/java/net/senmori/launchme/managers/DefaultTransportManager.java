package net.senmori.launchme.managers;

import net.senmori.launchme.LaunchMe;
import net.senmori.launchme.api.TransportManager;
import net.senmori.launchme.registries.IRegistry;
import net.senmori.launchme.registries.RegistryManager;
import net.senmori.launchme.api.Transport;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;

public class DefaultTransportManager extends AbstractManager implements TransportManager {

    private final IRegistry<Transport> transportRegistry = RegistryManager.ACTIVE.getRegistry( Transport.class );

    protected DefaultTransportManager(LaunchMe plugin) {
        super( plugin );
    }

    @Override
    public Transport getTransport(NamespacedKey key) {
        return transportRegistry.getValue( key );
    }

    @Override
    public Transport getTransport(Location location) {
        return transportRegistry.getValue( location );
    }

    @Override
    public void registerTransport(Transport transport) {
        transportRegistry.register( transport );
    }
}
