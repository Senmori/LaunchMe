package net.senmori.launchme.managers;

import net.senmori.launchme.LaunchMe;
import net.senmori.launchme.api.manager.TransportOptionsManager;
import net.senmori.launchme.api.TransportOptions;
import org.bukkit.NamespacedKey;

import java.util.Collection;
import java.util.Collections;

public class TransportOptionsManagerImpl extends RegisteredManager<TransportOptions> implements TransportOptionsManager {

    protected TransportOptionsManagerImpl(LaunchMe plugin) {
        super( plugin, TransportOptions.class );
    }


    @Override
    public TransportOptions getOption(NamespacedKey key) {
        return getRegistry().getValue( key );
    }

    @Override
    public void register(TransportOptions options) {
        getRegistry().register( options );
    }

    @Override
    public Collection<TransportOptions> getRegisteredOptions() {
        return Collections.unmodifiableCollection( getRegistry().getValues() );
    }
}
