package com.hobis.utils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Vector;


/**
 * Created by snag on 2015-06-16.
 */
public final class FileUtil {
    private FileUtil() {
    }


    // -
    public static final String LINE_SEPARATOR = System.lineSeparator();

    // ::
    public static Vector<String> text_readAll(String fp) {

        File t_f = new File(fp);
        if (t_f.exists()) {
            Scanner t_scan = null;
            Vector<String> t_vec = null;

            try {
                t_scan = new Scanner(t_f, StandardCharsets.UTF_8.name());
                t_scan.useDelimiter(LINE_SEPARATOR);
                while (t_scan.hasNextLine()) {
                    if (t_vec == null) {
                        t_vec = new Vector<>(3);
                    }
                    t_vec.add(t_scan.nextLine());
                }
            }
            catch (Exception e) {
            }

            try {
                t_scan.close();
            }
            catch (Exception e) {
            }

            if (t_vec == null) {
                return null;
            }
            else {
                return t_vec;
            }
        }
        else {
            return null;
        }
    }




}
