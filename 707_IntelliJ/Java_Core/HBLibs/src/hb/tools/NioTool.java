package hb.tools;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;


/**
 * Created by Hobis-PC on 2015-07-12.
 */
@SuppressWarnings("unused")
public final class NioTool {
    private NioTool() {
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
    public static FileChannel open_inputChannel() {
        FileChannel t_fc = null;
        try {
            t_fc = (new FileInputStream(Paths.get("").toFile())).getChannel();
        } catch (FileNotFoundException e) {
        }

        return t_fc;
    }

    // ::
    public static FileChannel open_outputChannel() {
        FileChannel t_fc = null;
        try {
            t_fc = (new FileOutputStream(Paths.get("").toFile())).getChannel();
        } catch (FileNotFoundException e) {
        }

        return t_fc;
    }
}
