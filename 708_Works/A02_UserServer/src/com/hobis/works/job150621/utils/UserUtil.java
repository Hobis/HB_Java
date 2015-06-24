package com.hobis.works.job150621.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by Hobis-PC on 2015-06-21.
 */
@SuppressWarnings("unused")
public final class UserUtil {
    public static final String MTL_SYSTEM = "[System] ";
    public static final String MTL_NORMAL = "[Normal] ";


    public static void trace(String mtl, String msg) {
        if (mtl == null) {
            mtl = MTL_NORMAL;
        }

        PrintStream t_ps = System.out;
        t_ps.print(mtl + msg);
    }

    public static void close(Closeable c) {
        if (c == null) return;

        try {
            c.close();
        }
        catch (IOException e) {
        }
    }
}
