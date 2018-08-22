package net.senmori.launchme.events;

import net.senmori.launchme.registries.IRegistry;
import org.bukkit.Keyed;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class RegistryEvent<V extends Keyed> extends Event {
    @NotNull
    private final IRegistry<V> registry;

    public RegistryEvent(@NotNull IRegistry<V> registry) {
        this.registry = registry;
    }

    @NotNull
    public IRegistry<V> getRegistry() {
        return registry;
    }
}
