package hb.tests;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Hobis-PC on 2015-07-05.
 */
@SuppressWarnings({"unused", "SpellCheckingInspection"})
public final class CallHelper {
    // #
    private CallHelper() {
    }


    // ::
    public static void close(Closeable c) {
        if (c != null) {
            try {
                c.close();
            }
            catch (IOException e) {
            }
        }
    }

    // ::
    public static void trace(String str) {
        System.out.println(str);
    }

}
