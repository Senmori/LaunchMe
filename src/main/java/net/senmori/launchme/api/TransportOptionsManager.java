package net.senmori.launchme.api;

import org.bukkit.NamespacedKey;

public interface TransportOptionsManager {

    TransportOptions getOption(NamespacedKey key);

    void register(TransportOptions options);
}
