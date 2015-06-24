package com.hobis.utils;


import java.util.regex.Pattern;

/**
 * Created by snag on 2015-06-16.
 */
public final class StringUtil {
    private StringUtil() {
    }


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
