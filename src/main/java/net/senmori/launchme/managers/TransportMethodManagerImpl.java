package net.senmori.launchme.managers;

import net.senmori.launchme.LaunchMe;
import net.senmori.launchme.api.manager.TransportMethodManager;
import net.senmori.launchme.api.TransportMethod;
import org.bukkit.NamespacedKey;

import java.util.Collection;
import java.util.Collections;

public class TransportMethodManagerImpl extends RegisteredManager<TransportMethod> implements TransportMethodManager {

    protected TransportMethodManagerImpl(LaunchMe plugin) {
        super( plugin, TransportMethod.class );
    }

    @Override
    public TransportMethod getTransportMethod(NamespacedKey key) {
        return getRegistry().getValue( key );
    }

    @Override
    public void register(TransportMethod method) {
        getRegistry().register( method );
    }

    @Override
    public Collection<TransportMethod> getRegisteredMethods() {
        return Collections.unmodifiableCollection( getRegistry().getValues() );
    }
}
