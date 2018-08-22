package net.senmori.launchme.transport.options;

import net.senmori.launchme.transport.TransportOptions;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class DefaultTransportOptions implements TransportOptions {

    private boolean canTransportMonsters = false;

    @Override
    public boolean transportMonsters() {
        return canTransportMonsters;
    }

    @Override
    public void setCanTransportMonsters(boolean value) {
        this.canTransportMonsters = value;
    }

    @Override
    public boolean canTransport(LivingEntity entity) {
        return canTransportMonsters || ( entity instanceof Player );
    }
}
