package org.spacehq.mc.protocol.util;

import org.junit.Test;

import com.github.steveice10.mc.protocol.data.game.Position;

import java.io.IOException;

import static com.github.steveice10.mc.protocol.util.NetUtil.readPosition;
import static com.github.steveice10.mc.protocol.util.NetUtil.writePosition;
import static org.spacehq.mc.protocol.ByteBufHelper.*;

public class NetUtilTest {

    @Test
    public void testPosition() throws IOException {
        writePosition(out, new Position(1, 61, -1));
        assertPosition(readPosition(in), 1, 61, -1);
    }

}
