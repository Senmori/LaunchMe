package net.senmori.launchme.events.registry;

import net.senmori.launchme.events.RegistryEvent;
import net.senmori.launchme.registries.IRegistry;
import org.bukkit.Keyed;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class RegistryRemoveEvent<V extends Keyed> extends RegistryEvent<V> {
    private static final HandlerList handlers = new HandlerList();

    private final V value;

    public RegistryRemoveEvent(@NotNull IRegistry<V> registry, @Nullable V value) {
        super( registry );
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
