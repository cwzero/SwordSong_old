package com.liquidforte.song.util;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class TileUtil {
    private static final Charset CONVERSION = Charset.forName("Cp437");

    public static char decodeTile(int x, int y) {
        return decodeTile(y * 16 + x);
    }

    public static char decodeTile(int tile) {
        return CONVERSION.decode(ByteBuffer.wrap(new byte[]{(byte) tile})).get();
    }

    public static int encodeTile(char tile) {
        return CONVERSION.encode(CharBuffer.wrap(new char[] {tile})).get();
    }
}
