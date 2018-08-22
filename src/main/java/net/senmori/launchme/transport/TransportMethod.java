package net.senmori.launchme.transport;

import net.senmori.launchme.targets.impl.EmptyTarget;
import org.bukkit.entity.LivingEntity;

public interface TransportMethod {

    /**
     * Transports an entity according to a given {@link Transport}'s options
     * and {@link TransportMethod}
     *
     * @param entity
     * @param transport
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
