package net.senmori.launchme.api;

import net.senmori.launchme.targets.EmptyTarget;
import org.bukkit.Keyed;
import org.bukkit.entity.LivingEntity;

public interface TransportMethod extends Keyed {

    /**
     * Transports an entity according to a given {@link Transport}'s options
     * and {@link TransportMethod}
     *
     * @param entity the entity to transport
     * @param transport the {@link Transport} to retrieve information from
     */
    void transport(LivingEntity entity, Transport transport);

    default boolean teleportSafe(LivingEntity entity, Transport transport) {
        if (isValid( transport )) {
            transport(entity, transport );
            return true;
        }
        return false;
    }

    default boolean isValid(Transport transport) {
        return transport.getTarget() != null && !(transport.getTarget() instanceof EmptyTarget);
    }
}
