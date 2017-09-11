package com.github.steveice10.mc.protocol.packet.ingame.server.world;

import org.spacehq.packetlib.io.NetInput;
import org.spacehq.packetlib.io.NetOutput;
import org.spacehq.packetlib.packet.Packet;

import com.github.steveice10.mc.protocol.data.game.Position;
import com.github.steveice10.mc.protocol.util.NetUtil;

import java.io.IOException;

public class ServerOpenTileEntityEditorPacket implements Packet {

    private Position position;

    @SuppressWarnings("unused")
    private ServerOpenTileEntityEditorPacket() {
    }

    public ServerOpenTileEntityEditorPacket(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }

    @Override
    public void read(NetInput in) throws IOException {
        this.position = NetUtil.readPosition(in);
    }

    @Override
    public void write(NetOutput out) throws IOException {
        NetUtil.writePosition(out, this.position);
    }

    @Override
    public boolean isPriority() {
        return false;
    }

}
