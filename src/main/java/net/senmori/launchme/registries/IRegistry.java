package net.senmori.launchme.registries;

import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Map;

public interface IRegistry<V extends Keyed> extends Keyed, IRegistryLocatable<V> {

    Class<V> getSuperType();

    Plugin getOwner();

    void register(@NotNull V value);

    void registerAll(@NotNull V... values);

    boolean containsKey(@Nullable NamespacedKey key);

    boolean containsValue(@Nullable V value);

    @Nullable
    V getValue(@Nullable NamespacedKey key);

    @Nullable
    NamespacedKey getKey(@Nullable V value);

    @NotNull
    Collection<V> getValues();

    Collection<Map.Entry<NamespacedKey, V>> getEntries();

    /**
     * Callback fired when objects are added to the registry. This will
     * fire <i>after</i> all relative events have processed.
     */
    interface AddCallback<V extends Keyed> {
        void onAdd(@NotNull IRegistry<V> registry, @NotNull V value, @Nullable V old);
    }

    /**
     * Callback fired when objects are removed from the registry. This will
     * fire <i>after</i> all relative events have processed.
     */
    interface RemoveCallback<V extends Keyed> {
        void onRemove(@NotNull IRegistry<V> registry, @NotNull V value);
    }

    /**
     * Callback fired when a registry is cleared. This will fire
     * <i>after</i> all relative events have processed.
     */
    interface ClearCallback<V extends Keyed> {
        void onClear(@NotNull IRegistry<V> registry);
    }

    /**
     * Callback fired when a register instance is created.
     */
    interface CreateCallback<V extends Keyed> {
        void onCreate(@NotNull IRegistry<V> registry);
    }
}
