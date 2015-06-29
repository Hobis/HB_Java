package hb.tools;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by snag on 2015-06-29.
 */
@SuppressWarnings("unused")
public final class FileTool {
    private FileTool() {
    }



    // - 파일 패스 구분자
    public static final String PATH_SEPARATOR = System.getProperty("path.separator");


    // ::
    public static String readAll_txt(String fp) {

        File t_f = new File(fp);
        if (t_f.exists()) {
            Scanner t_scan = null;
            Vector<String> t_vec = null;

            try {
                t_scan = new Scanner(t_f, StandardCharsets.UTF_8.name());
                t_scan.useDelimiter(StringTool.LINE_SEPARATOR);
                while (t_scan.hasNextLine()) {
                    if (t_vec == null) {
                        t_vec = new Vector<>();
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
                String t_str = t_vec.toString();
                t_vec.clear();
                return t_str;
            }
        }
        else {
            return null;
        }

    }
}
