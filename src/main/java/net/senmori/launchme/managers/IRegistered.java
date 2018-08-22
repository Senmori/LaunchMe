package net.senmori.launchme.managers;

import net.senmori.launchme.registries.IRegistry;
import org.bukkit.Keyed;

public interface IRegistered {

    <V extends Keyed>IRegistry<V> getRegistry();
}
