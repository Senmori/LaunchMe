package net.senmori.launchme.events;

import net.senmori.launchme.registries.IRegistry;
import org.bukkit.event.Event;

public abstract class RegistryEvent extends Event {
    private IRegistry<?> registry;

    protected RegistryEvent(IRegistry<?> registry) {
        this.registry = registry;
    }

    public IRegistry<?> getRegistry() {
        return registry;
    }
}
