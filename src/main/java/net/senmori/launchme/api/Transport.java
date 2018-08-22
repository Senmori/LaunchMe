package net.senmori.launchme.api;

import net.senmori.launchme.targets.EmptyTarget;
import org.bukkit.Keyed;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;

/**
 * Represents a method of transporting entities from one Location to another.
 */
public interface Transport extends Keyed {

    /**
     * Get the {@link TransportType} this transport uses.
     *
     * @return the TransportType
     */
    TransportType getTransportType();

    /**
     * Get the {@link TransportOptions} for this Transport.
     * TransportOptions dictate certain behavior for transports.
     *
     * @return the {@link TransportOptions}
     */
    TransportOptions getOptions();

    /**
     * Get the {@link Location} of this Transport.
     *
     * @return the Location of this Transport.
     */
    Location getLocation();

    /**
     * Get the current {@link Target} for this Transport.
     * If no target is set, {@link EmptyTarget}
     * will be used instead.
     *
     * @return the current Target
     */
    Target getTarget();

    /**
     * Set the current {@link Target} for this Transport.
     *
     * @param target the new Target
     */
    void setTarget(Target target);

    /**
     * Check if the {@link LivingEntity} can activate this Transport.
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
