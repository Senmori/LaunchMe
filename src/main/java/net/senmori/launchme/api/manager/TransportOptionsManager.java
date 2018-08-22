package net.senmori.launchme.api.manager;

import net.senmori.launchme.api.TransportOptions;
import org.bukkit.NamespacedKey;

import java.util.Collection;

public interface TransportOptionsManager {

    TransportOptions getOption(NamespacedKey key);

    void registerTransportOption(TransportOptions options);

    Collection<TransportOptions> getRegisteredOptions();
}
