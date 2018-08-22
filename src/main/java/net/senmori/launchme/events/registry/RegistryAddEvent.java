package net.senmori.launchme.events.registry;

import net.senmori.launchme.events.RegistryEvent;
import net.senmori.launchme.registries.IRegistry;
import org.bukkit.Keyed;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class RegistryAddEvent<V extends Keyed> extends RegistryEvent<V> {
    private static final HandlerList handlers = new HandlerList();

    private V newValue;
    private V oldValue;

    public RegistryAddEvent(@NotNull IRegistry<V> registry, @NotNull V newValue, @Nullable V old) {
        super( registry );
        this.newValue = newValue;
        this.oldValue = old;
    }

    public V getNewValue() {
        return newValue;
    }

    public V getOldValue() {
        return oldValue;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
