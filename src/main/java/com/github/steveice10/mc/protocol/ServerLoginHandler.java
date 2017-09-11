package com.github.steveice10.mc.protocol;

import org.spacehq.packetlib.Session;

public interface ServerLoginHandler {
    public void loggedIn(Session session);
}
