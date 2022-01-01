package com.liquidforte.song.util;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class TileUtil {
    private static final Charset CONVERSION = Charset.forName("Cp437");

    public static char decodeTile(int x, int y) {
        return decodeTile((byte) (y * 16 + x));
    }

    public static char decodeTile(byte tile) {
        return CONVERSION.decode(ByteBuffer.wrap(new byte[]{tile})).get();
    }

    public static byte encodeTile(char tile) {
        return CONVERSION.encode(CharBuffer.wrap(new char[]{tile})).get();
    }
}
