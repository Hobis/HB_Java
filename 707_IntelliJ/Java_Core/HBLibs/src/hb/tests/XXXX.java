package hb.tests;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Hobis-PC on 2015-07-02.
 */
public class XXXX {

    private static void p_close(Closeable c) {
        if (c != null) {
            try {
                c.close();
            }
            catch (IOException e) {
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("# 서버를 시작함");


        boolean t_isLoop = true;

        ServerSocket t_ss = null;
        Socket t_cs = null;

        BufferedReader t_br = null;
        BufferedWriter t_bw = null;

        String t_ls = null;


        try {
            t_ss = new ServerSocket(9957);

            while (t_isLoop) {
                System.out.println("# 클라이언트 대기중");
                t_cs = t_ss.accept();
                System.out.println("# 클라이언트 들어옴");

                t_br = new BufferedReader(new InputStreamReader(t_cs.getInputStream()));
                t_bw = new BufferedWriter(new OutputStreamWriter(t_cs.getOutputStream()));
                t_bw.write("슈발꺼");
                t_bw.flush();

                while ((t_ls = t_br.readLine()) != null) {
                    System.out.println(t_ls);
                }
            }

        }
        catch (IOException e) {
            e.printStackTrace();
            p_close(t_cs);
            p_close(t_br);
        }







        p_close(t_ss);
        t_ss = null;

        p_close(t_cs);
        t_cs = null;

        p_close(t_br);
        t_br = null;


        System.out.println("# 서버를 종료함");
    }

}
