package net.senmori.launchme.managers;

import net.senmori.launchme.LaunchMe;
import net.senmori.launchme.api.TransportOptionsManager;
import net.senmori.launchme.registries.IRegistry;
import net.senmori.launchme.registries.RegistryManager;
import net.senmori.launchme.api.TransportOptions;
import org.bukkit.NamespacedKey;

public class DefaultTransportOptionsManager extends AbstractManager implements TransportOptionsManager {

    private final IRegistry<TransportOptions> transportOptionsRegistry = RegistryManager.ACTIVE.getRegistry( TransportOptions.class );

    protected DefaultTransportOptionsManager(LaunchMe plugin) {
        super( plugin );
    }


    @Override
    public TransportOptions getOption(NamespacedKey key) {
        return transportOptionsRegistry.getValue( key );
    }

    @Override
    public void register(TransportOptions options) {
        transportOptionsRegistry.register( options );
    }
}
