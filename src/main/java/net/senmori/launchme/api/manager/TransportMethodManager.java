package net.senmori.launchme.api.manager;

import net.senmori.launchme.api.TransportMethod;
import org.bukkit.NamespacedKey;

import java.util.Collection;

public interface TransportMethodManager {

    TransportMethod getTransportMethod(NamespacedKey key);

    void register(TransportMethod method);

    Collection<TransportMethod> getRegisteredMethods();
}
