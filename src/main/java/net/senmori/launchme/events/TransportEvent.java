package net.senmori.launchme.events;

import net.senmori.launchme.api.Transport;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public abstract class TransportEvent extends Event {

    private final Transport transport;
    public TransportEvent(@NotNull Transport transport) {
        this.transport = transport;
    }

    @NotNull
    public Transport getTransport() {
        return transport;
    }
}
