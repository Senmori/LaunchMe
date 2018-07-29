package net.senmori.launchme.transport;

import net.senmori.launchme.targets.EmptyTarget;
import net.senmori.launchme.targets.Target;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;

/**
 * Represents a method of transporting entities from one Location to another.
 */
public interface ITransport {

    /**
     * Get the name of this ITransport.
     *
     * @return the name of this ITransport
     */
    String getName();

    /**
     * Get the {@link Location} of this ITransport.
     *
     * @return the Location of this ITransport.
     */
    Location getLocation();

    /**
     * Get the {@link ITransportOptions} for this ITransport.
     * TransportOptions dictate certain behavior for transports.
     *
     * @return the {@link ITransportOptions}
     */
    ITransportOptions getOptions();

    /**
     * Get the current {@link Target} for this ITransport.
     * If no target is set, {@link EmptyTarget}
     * will be used instead.
     *
     * @return the current Target, or EmptyTarget
     */
    Target getTarget();

    /**
     * Set the current {@link Target} for this ITransport.
     *
     * @param target the new Target
     */
    void setTarget(Target target);

    /**
     * Check if the {@link LivingEntity} can activate this ITransport.
     *
     * @param entity the entity to check
     * @return true if the entity can be transported
     */
    boolean canActivate(LivingEntity entity);

    /**
     * Activate this transport.
     *
     * @param entity the entity to transport
     */
    void activate(LivingEntity entity);
}
