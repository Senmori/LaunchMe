package net.senmori.launchme.managers;

import net.senmori.launchme.LaunchMe;
import net.senmori.launchme.api.TransportMethodManager;
import net.senmori.launchme.registries.IRegistry;
import net.senmori.launchme.registries.RegistryManager;
import net.senmori.launchme.api.TransportMethod;
import org.bukkit.NamespacedKey;

public class DefaultTransportMethodManager extends AbstractManager implements TransportMethodManager {

    private final IRegistry<TransportMethod> transportMethodRegistry = RegistryManager.ACTIVE.getRegistry( TransportMethod.class );

    protected DefaultTransportMethodManager(LaunchMe plugin) {
        super( plugin );
    }

    @Override
    public TransportMethod getTransportMethod(NamespacedKey key) {
        return transportMethodRegistry.getValue( key );
    }

    @Override
    public void register(TransportMethod method) {
        transportMethodRegistry.register( method );
    }
}
