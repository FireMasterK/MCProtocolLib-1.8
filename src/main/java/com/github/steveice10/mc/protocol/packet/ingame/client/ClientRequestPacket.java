package com.github.steveice10.mc.protocol.packet.ingame.client;

import org.spacehq.packetlib.io.NetInput;
import org.spacehq.packetlib.io.NetOutput;
import org.spacehq.packetlib.packet.Packet;

import com.github.steveice10.mc.protocol.data.game.values.ClientRequest;
import com.github.steveice10.mc.protocol.data.game.values.MagicValues;

import java.io.IOException;

public class ClientRequestPacket implements Packet {

    private ClientRequest request;

    @SuppressWarnings("unused")
    private ClientRequestPacket() {
    }

    public ClientRequestPacket(ClientRequest request) {
        this.request = request;
    }

    public ClientRequest getRequest() {
        return this.request;
    }

    @Override
    public void read(NetInput in) throws IOException {
        this.request = MagicValues.key(ClientRequest.class, in.readUnsignedByte());
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeByte(MagicValues.value(Integer.class, this.request));
    }

    @Override
    public boolean isPriority() {
        return false;
    }

}
