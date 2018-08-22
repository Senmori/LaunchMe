package net.senmori.launchme.api;

import net.senmori.launchme.api.manager.*;

/**
 * A central interface that simply extends all other interfaces that are
 * public-facing. <br>
 * This is simply a convenient replacement for retrieving each service
 * individually.
 */
public interface LaunchMeAPI extends TransportManager, TargetManager, TransportMethodManager, TransportOptionsManager, TransportTypeManager {
}
