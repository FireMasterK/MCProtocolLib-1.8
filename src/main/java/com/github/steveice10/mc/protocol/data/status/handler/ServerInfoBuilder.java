package com.github.steveice10.mc.protocol.data.status.handler;

import org.spacehq.packetlib.Session;

import com.github.steveice10.mc.protocol.data.status.ServerStatusInfo;

public interface ServerInfoBuilder {

    public ServerStatusInfo buildInfo(Session session);

}
