package net.senmori.launchme.events.registry;

import net.senmori.launchme.events.RegistryEvent;
import net.senmori.launchme.registries.IRegistry;
import org.bukkit.Keyed;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public final class RegistryClearEvent<V extends Keyed> extends RegistryEvent<V> {
    private static final HandlerList handlers = new HandlerList();

    public RegistryClearEvent(@NotNull IRegistry<V> registry) {
        super( registry );
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
