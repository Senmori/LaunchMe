package net.senmori.launchme.targets;

import org.bukkit.Location;
import org.bukkit.NamespacedKey;

/**
 * Represents a {@link Location} in a World that can receive
 */
public interface Target {

    NamespacedKey getName();

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
