package hb.tools;

import java.util.regex.Pattern;

/**
 * Created by Hobis-PC on 2015-06-24.
 */
@SuppressWarnings("unused")
public final class StringTool {
    private StringTool() {
    }


    // - 텍스트 라인 구분자
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");


    private static final Pattern _TRIM_LEFT = Pattern.compile("^\\s+");
    private static final Pattern _TRIM_RIGHT = Pattern.compile("\\s+$");

    // ::
    public static String trim_left(String str) {
        return _TRIM_LEFT.matcher(str).replaceAll("");
    }

    // ::
    public static String trim_right(String str) {
        return _TRIM_RIGHT.matcher(str).replaceAll("");
    }



}
