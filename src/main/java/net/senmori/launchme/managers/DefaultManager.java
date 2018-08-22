package net.senmori.launchme.managers;

import net.senmori.launchme.LaunchMe;
import net.senmori.launchme.api.*;
import net.senmori.launchme.api.Target;
import net.senmori.launchme.api.Transport;
import net.senmori.launchme.api.TransportMethod;
import net.senmori.launchme.api.TransportOptions;
import net.senmori.launchme.api.TransportType;
import net.senmori.launchme.api.manager.*;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;

import java.util.Collection;

public class DefaultManager extends AbstractManager implements LaunchMeAPI {

    private final TargetManager targetManager;
    private final TransportManager transportManager;
    private final TransportMethodManager transportMethodManager;
    private final TransportOptionsManager transportOptionsManager;
    private final TransportTypeManager transportTypeManager;

    public DefaultManager(LaunchMe plugin) {
        super( plugin );
        this.targetManager = new TargetManagerImpl( getPlugin() );
        this.transportManager = new TransportManagerImpl( getPlugin() );
        this.transportMethodManager = new TransportMethodManagerImpl( getPlugin() );
        this.transportOptionsManager = new TransportOptionsManagerImpl( getPlugin() );
        this.transportTypeManager = new TransportTypeManagerImpl( getPlugin() );
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
    public Collection<Target> getRegisteredTargets() {
        return targetManager.getRegisteredTargets();
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
    public Collection<Transport> getRegisteredTransports() {
        return transportManager.getRegisteredTransports();
    }

    @Override
    public TransportMethod getTransportMethod(NamespacedKey key) {
        return transportMethodManager.getTransportMethod( key );
    }

    @Override
    public void registerTransportMethod(TransportMethod method) {
        transportMethodManager.registerTransportMethod( method );
    }

    @Override
    public Collection<TransportMethod> getRegisteredMethods() {
        return transportMethodManager.getRegisteredMethods();
    }

    @Override
    public TransportOptions getOption(NamespacedKey key) {
        return transportOptionsManager.getOption( key );
    }

    @Override
    public void registerTransportOption(TransportOptions options) {
        transportOptionsManager.registerTransportOption( options );
    }

    @Override
    public Collection<TransportOptions> getRegisteredOptions() {
        return transportOptionsManager.getRegisteredOptions();
    }

    @Override
    public TransportType getTransportType(NamespacedKey key) {
        return transportTypeManager.getTransportType( key );
    }

    @Override
    public void registerTransportType(TransportType type) {
        transportTypeManager.registerTransportType( type );
    }

    @Override
    public TransportTypeBuilder getBuilder(NamespacedKey key) {
        return new TransportTypeBuilder( key );
    }

    @Override
    public Collection<TransportType> getRegisteredTypes() {
        return transportTypeManager.getRegisteredTypes();
    }
}
