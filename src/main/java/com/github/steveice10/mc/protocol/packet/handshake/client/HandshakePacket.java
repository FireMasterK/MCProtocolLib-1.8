package com.github.steveice10.mc.protocol.packet.handshake.client;

import org.spacehq.packetlib.io.NetInput;
import org.spacehq.packetlib.io.NetOutput;
import org.spacehq.packetlib.packet.Packet;

import com.github.steveice10.mc.protocol.data.game.values.HandshakeIntent;
import com.github.steveice10.mc.protocol.data.game.values.MagicValues;

import java.io.IOException;

public class HandshakePacket implements Packet {

    private int protocolVersion;
    private String hostname;
    private int port;
    private HandshakeIntent intent;

    @SuppressWarnings("unused")
    private HandshakePacket() {
    }

    public HandshakePacket(int protocolVersion, String hostname, int port, HandshakeIntent intent) {
        this.protocolVersion = protocolVersion;
        this.hostname = hostname;
        this.port = port;
        this.intent = intent;
    }

    public int getProtocolVersion() {
        return this.protocolVersion;
    }

    public String getHostName() {
        return this.hostname;
    }

    public int getPort() {
        return this.port;
    }

    public HandshakeIntent getIntent() {
        return this.intent;
    }

    @Override
    public void read(NetInput in) throws IOException {
        this.protocolVersion = in.readVarInt();
        this.hostname = in.readString();
        this.port = in.readUnsignedShort();
        this.intent = MagicValues.key(HandshakeIntent.class, in.readVarInt());
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeVarInt(this.protocolVersion);
        out.writeString(this.hostname);
        out.writeShort(this.port);
        out.writeVarInt(MagicValues.value(Integer.class, this.intent));
    }

    @Override
    public boolean isPriority() {
        return true;
    }

}
