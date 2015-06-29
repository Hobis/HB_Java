package com.hobis.works.job150629;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by snag on 2015-06-29.
 */
@SuppressWarnings("unused")
public final class RollUtil {
    private RollUtil() {
    }


    public static final String MTL_SYSTEM = "[#System] ";
    public static final String MTL_NORMAL = "[#Normal] ";




    // ::
    public static String get_hostAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        }
        catch (UnknownHostException e) {
        }
        return null;
    }




    // ::
    public static void trace(String mtl, String msg) {
        if (mtl == null) {
            mtl = MTL_SYSTEM;
        }

        PrintStream t_ps = System.out;
        t_ps.println(mtl + msg);
    }

    // ::
    public static void trace( String msg) {
        trace(null, msg);
    }


    // ::
    public static void close(Closeable c) {
        if (c == null) return;

        try {
            c.close();
        }
        catch (IOException e) {
        }
    }

}
