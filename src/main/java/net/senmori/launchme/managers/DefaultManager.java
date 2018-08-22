package net.senmori.launchme.managers;

import net.senmori.launchme.LaunchMe;
import net.senmori.launchme.api.TransportTypeBuilder;
import net.senmori.launchme.registries.IRegistry;
import net.senmori.launchme.registries.RegistryManager;
import net.senmori.launchme.api.TargetManager;
import net.senmori.launchme.api.TransportManager;
import net.senmori.launchme.api.TransportTypeFactory;
import net.senmori.launchme.targets.Target;
import net.senmori.launchme.transport.Transport;
import net.senmori.launchme.transport.TransportType;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;

public class DefaultManager implements TargetManager, TransportManager, TransportTypeFactory {

    private final IRegistry<Target> targetRegistry = RegistryManager.ACTIVE.getRegistry( Target.class );
    private final IRegistry<Transport> transportRegistry = RegistryManager.ACTIVE.getRegistry( Transport.class );
    private final IRegistry<TransportType> transportTypeRegistry = RegistryManager.ACTIVE.getRegistry( TransportType.class );
    private final LaunchMe plugin;

    public DefaultManager(LaunchMe plugin) {
        this.plugin = plugin;
    }

    @Override
    public Target getTarget(NamespacedKey key) {
        return targetRegistry.getValue( key );
    }

    @Override
    public Target getTarget(Location location) {
        return targetRegistry.getValue( location );
    }

    @Override
    public void registerTarget(Target target) {
        targetRegistry.register( target );
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
