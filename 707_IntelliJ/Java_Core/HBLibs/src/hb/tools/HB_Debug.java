package hb.tools;

/**
 * Created by snag on 2015-06-26.
 */
@SuppressWarnings("unused")
public final class HB_Debug {

    public static final String TYPE_CONSOLE = "type_console";

    public static final String TAG_NORMAL = "[hb] ";


    // ::
    private static String p_get_msg(String tag, String msg) {
        return tag + msg;
    }

    // ::
    public static void test(String type, String tag, String msg) {
        if (type == null)
            type = TYPE_CONSOLE;

        if (tag == null)
            tag = TAG_NORMAL;

        switch (type) {
            case TYPE_CONSOLE: {
                System.out.println(p_get_msg(tag, msg));
                break;
            }
        }
    }

    // ::
    public static void test(String tag, String msg) {
        if (tag == null)
            tag = TAG_NORMAL;

        System.out.println(p_get_msg(tag, msg));
    }

    // ::
    public static void test(String msg) {
        System.out.println(msg);
    }


}
