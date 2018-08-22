package net.senmori.launchme.api;

import org.bukkit.NamespacedKey;

public interface TransportMethodManager {

    TransportMethod getTransportMethod(NamespacedKey key);

    void register(TransportMethod method);
}
