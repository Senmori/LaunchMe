package net.senmori.launchme.managers;

import net.senmori.launchme.LaunchMe;
import net.senmori.launchme.api.*;
import net.senmori.launchme.api.Target;
import net.senmori.launchme.api.Transport;
import net.senmori.launchme.api.TransportMethod;
import net.senmori.launchme.api.TransportOptions;
import net.senmori.launchme.api.TransportType;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;

public class DefaultManager extends AbstractManager implements LaunchMeAPI {

    private final TargetManager targetManager;
    private final TransportManager transportManager;
    private final TransportMethodManager transportMethodManager;
    private final TransportOptionsManager transportOptionsManager;
    private final TransportTypeManager transportTypeManager;

    public DefaultManager(LaunchMe plugin) {
        super( plugin );
        this.targetManager = new DefaultTargetManager( getPlugin() );
        this.transportManager = new DefaultTransportManager( getPlugin() );
        this.transportMethodManager = new DefaultTransportMethodManager( getPlugin() );
        this.transportOptionsManager = new DefaultTransportOptionsManager( getPlugin() );
        this.transportTypeManager = new DefaultTransportTypeManager( getPlugin() );
    }

    @Override
    public Target getTarget(NamespacedKey key) {
        return targetManager.getTarget( key );
    }

    @Override
    public Target getTarget(Location location) {
        return targetManager.getTarget( location );
    }

    @Override
    public void registerTarget(Target target) {
        targetManager.registerTarget( target );
    }

    @Override
    public Transport getTransport(NamespacedKey key) {
        return transportManager.getTransport( key );
    }

    @Override
    public Transport getTransport(Location location) {
        return transportManager.getTransport( location );
    }

    @Override
    public void registerTransport(Transport transport) {
        transportManager.registerTransport( transport );
    }

    @Override
    public TransportMethod getTransportMethod(NamespacedKey key) {
        return transportMethodManager.getTransportMethod( key );
    }

    @Override
    public void register(TransportMethod method) {
        transportMethodManager.register( method );
    }

    @Override
    public TransportOptions getOption(NamespacedKey key) {
        return transportOptionsManager.getOption( key );
    }

    @Override
    public void register(TransportOptions options) {
        transportOptionsManager.register( options );
    }

    @Override
    public TransportType getTransportType(NamespacedKey key) {
        return transportTypeManager.getTransportType( key );
    }

    @Override
    public void register(TransportType type) {
        transportTypeManager.register( type );
    }

    @Override
    public TransportTypeBuilder getBuilder(NamespacedKey key) {
        return new TransportTypeBuilder( key );
    }
}
