package net.senmori.launchme.api;

import org.bukkit.Keyed;
import org.bukkit.Location;

/**
 * Represents a {@link Location} in a World that can receive
 */
public interface Target extends Keyed {

    Location getLocation();

    /**
     * Is this a valid {@link Target}? A valid Target is one
     * whose {@link #getLocation()} has a world and valid coordinates
     * within it.
     *
     * @return true if valid
     */
    default boolean isValid() {
        return getLocation() != null && getLocation().getWorld() != null;
    }
}
