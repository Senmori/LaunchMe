package net.senmori.launchme.managers;

import net.senmori.launchme.targets.EmptyTarget;
import net.senmori.launchme.targets.Target;

/**
 * This manager is the contract for how {@link Target}s are
 * queried, registered, and removed.
 */
public interface ITargetManager {

    /**
     * Check if a {@link Target} is registered
     *
     * @param name the name of the Target
     * @return true if the Target is already registered
     */
    boolean isRegistered(String name);

    /**
     * Register a new {@link Target}. A Target can fail registration
     * if it is null, an {@link EmptyTarget} or if that Target's name
     * is already taken.
     *
     * @param target the new Target to register
     * @return true if the Target was successfully registered.
     */
    boolean registerTarget(Target target);

    /**
     * Get a {@link Target} that matches the given name.
     * Target names are not case-sensitive.
     * If no Target is found with the given name, an {@link EmptyTarget}
     * will be returned instead.
     *
     * @param name the name of the Target
     * @return the {@link Target}, or {@link EmptyTarget} if none found.
     */
    Target getTarget(String name);

    /**
     * Remove a {@link Target} that matches the given name. The name is not
     * case-sensitive.
     *
     * @param name the name of the Target to remove
     * @return true if the Target was successfully removed
     */
    boolean removeTarget(String name);

    /**
     * Remove a {@link Target}.
     *
     * @param target the Target to remove
     * @return true if the Target was successfully removed
     */
    boolean removeTarget(Target target);
}
