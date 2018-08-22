package net.senmori.launchme.managers;

import net.senmori.launchme.LaunchMe;
import net.senmori.launchme.api.TransportType;
import net.senmori.launchme.api.TransportTypeBuilder;
import net.senmori.launchme.api.manager.TransportTypeManager;
import org.bukkit.NamespacedKey;

import java.util.Collection;
import java.util.Collections;

public class TransportTypeManagerImpl extends RegisteredManager<TransportType> implements TransportTypeManager {

    public TransportTypeManagerImpl(LaunchMe plugin) {
        super( plugin, TransportType.class );
    }

    @Override
    public TransportType getTransportType(NamespacedKey key) {
        return getRegistry().getValue( key );
    }

    @Override
    public void register(TransportType type) {
        getRegistry().register( type );
    }

    @Override
    public TransportTypeBuilder getBuilder(NamespacedKey key) {
        return new TransportTypeBuilder( key );
    }

    @Override
    public Collection<TransportType> getRegisteredTypes() {
        return Collections.unmodifiableCollection( getRegistry().getValues() );
    }
}
