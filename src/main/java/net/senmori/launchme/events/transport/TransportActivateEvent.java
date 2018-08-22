package net.senmori.launchme.events.transport;

import net.senmori.launchme.api.Transport;
import net.senmori.launchme.events.TransportEvent;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class TransportActivateEvent extends TransportEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();

    private final LivingEntity entity;
    private boolean cancelled = false;
    public TransportActivateEvent(@NotNull Transport transport, @NotNull LivingEntity entity) {
        super( transport );
        this.entity = entity;
    }

    public LivingEntity getEntity() {
        return entity;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
