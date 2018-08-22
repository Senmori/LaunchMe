package net.senmori.launchme.transport;

import org.bukkit.Keyed;
import org.bukkit.entity.LivingEntity;

public interface TransportOptions extends Keyed {

    /**
     * Check if this Transport can transport non-player entities.
     *
     * @return true if non-player entities should be transported.
     */
    boolean transportMonsters();

    /**
     * Set if this Transport can transport non-player entities.
     *
     * @param value the new {@link #transportMonsters()} value
     */
    void setCanTransportMonsters(boolean value);

    /**
     * Check if this Transport can transport the given entity.
     *
     * @param entity the entity to check
     * @return true if the entity can be transported
     */
    boolean canTransport(LivingEntity entity);
}
