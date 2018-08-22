package net.senmori.launchme.managers;

import net.senmori.launchme.LaunchMe;
import net.senmori.launchme.api.manager.TransportManager;
import net.senmori.launchme.api.Transport;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;

import java.util.Collection;
import java.util.Collections;

public class TransportManagerImpl extends RegisteredManager<Transport> implements TransportManager {

    protected TransportManagerImpl(LaunchMe plugin) {
        super( plugin, Transport.class );
    }

    @Override
    public Transport getTransport(NamespacedKey key) {
        return getRegistry().getValue( key );
    }

    @Override
    public Transport getTransport(Location location) {
        return getRegistry().getValue( location );
    }

    @Override
    public void registerTransport(Transport transport) {
        getRegistry().register( transport );
    }

    @Override
    public Collection<Transport> getRegisteredTransports() {
        return Collections.unmodifiableCollection( getRegistry().getValues() );
    }
}
