package net.senmori.launchme.managers;

import net.senmori.launchme.LaunchMe;
import net.senmori.launchme.api.TransportTypeBuilder;
import net.senmori.launchme.api.TransportTypeManager;
import net.senmori.launchme.registries.IRegistry;
import net.senmori.launchme.registries.RegistryManager;
import net.senmori.launchme.api.TransportType;
import org.bukkit.NamespacedKey;

public class DefaultTransportTypeManager extends AbstractManager implements TransportTypeManager {

    private final IRegistry<TransportType> transportTypeRegistry = RegistryManager.ACTIVE.getRegistry( TransportType.class );

    public DefaultTransportTypeManager(LaunchMe plugin) {
        super( plugin );
    }

    @Override
    public TransportType getTransportType(NamespacedKey key) {
        return transportTypeRegistry.getValue( key );
    }

    @Override
    public void register(TransportType type) {
        transportTypeRegistry.register( type );
    }

    @Override
    public TransportTypeBuilder getBuilder(NamespacedKey key) {
        return new TransportTypeBuilder( key );
    }
}
