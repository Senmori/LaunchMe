package net.senmori.launchme.targets;

import org.bukkit.Location;

/**
 * Represents the targets for a launch pad.
 */
public abstract class Target {

    /**
     * Gets the name of this targets.
     *
     * @return the name of the targets
     */
    public abstract String getName();

    /**
     * Get the {@link Location} of this targets.
     *
     * @return the location of this targets
     */
    public abstract Location getLocation();

    /**
     * Is this a valid {@link Target}? A valid Target is one
     * whose {@link #getLocation()} has a world and valid coordinates
     * within it.
     *
     * @return true if valid
     */
    public boolean isValid() {
        return true;
    }
}
