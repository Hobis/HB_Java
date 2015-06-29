package hb.tools;

/**
 * Created by snag on 2015-06-26.
 */
@SuppressWarnings("unused")
public final class DebugTool {
    private DebugTool() {
    }





    // -
    public static final String TYPE_CONSOLE = "type_console";
    // -
    public static final String TAG_NORMAL = "[hb] ";



    // ::
    public static void trace(String type, String tag, String msg) {
        if (type == null)
            type = TYPE_CONSOLE;

        if (tag == null)
            tag = TAG_NORMAL;

        switch (type) {
            case TYPE_CONSOLE: {
                System.out.println(tag + msg);
                break;
            }
        }
    }

    // ::
    public static void trace(String tag, String msg) {
        if (tag == null)
            tag = TAG_NORMAL;

        trace(TYPE_CONSOLE, tag, msg);
    }

    // ::
    public static void trace(String msg) {
        trace(TAG_NORMAL, msg);
    }


}
