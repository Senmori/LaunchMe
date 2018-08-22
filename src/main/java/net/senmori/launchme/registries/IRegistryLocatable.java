package net.senmori.launchme.registries;

import org.bukkit.Keyed;
import org.bukkit.Location;

public interface IRegistryLocatable<V extends Keyed> {

    V getValue(Location location);
}
