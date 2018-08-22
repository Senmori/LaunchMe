package net.senmori.launchme.registries;

import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public interface IRegistry<V extends Keyed> {

    void register(@NotNull V value);

    void registerAll(@NotNull V... values);

    boolean containsKey(@Nullable NamespacedKey key);

    boolean containsValue(@Nullable V value);

    V remove(@Nullable NamespacedKey key);

    void clear();

    @Nullable
    V getValue(@Nullable NamespacedKey key);

    @Nullable
    NamespacedKey getKey(@Nullable V value);

    @NotNull
    Collection<V> getValues();
}
