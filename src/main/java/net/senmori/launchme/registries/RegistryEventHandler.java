package net.senmori.launchme.registries;

import net.senmori.launchme.events.registry.RegistryAddEvent;
import net.senmori.launchme.events.registry.RegistryClearEvent;
import net.senmori.launchme.events.registry.RegistryCreateEvent;
import net.senmori.launchme.events.registry.RegistryRemoveEvent;
import org.bukkit.Bukkit;
import org.bukkit.Keyed;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RegistryEventHandler<V extends Keyed> implements IRegistry.AddCallback<V>, IRegistry.RemoveCallback<V>, IRegistry.ClearCallback<V>, IRegistry.CreateCallback<V> {
    @Override
    public void onAdd(@NotNull IRegistry<V> registry, @NotNull V value, @Nullable V old) {
        call( new RegistryAddEvent<>( registry, value, old ) );
    }

    @Override
    public void onRemove(@NotNull IRegistry<V> registry, @NotNull V value) {
        call( new RegistryRemoveEvent<>( registry, value ) );
    }

    @Override
    public void onClear(@NotNull IRegistry<V> registry) {
        call( new RegistryClearEvent<>( registry ) );
    }

    @Override
    public void onCreate(@NotNull IRegistry<V> registry) {
        call( new RegistryCreateEvent<>( registry ) );
    }

    private void call(Event event) {
        Bukkit.getPluginManager().callEvent( event );
    }
}
