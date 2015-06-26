package hb.works.servers;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by snag on 2015-06-25.
 */
@SuppressWarnings("UnusedAssignment")
public final class RollMain {




    public static void main(String[] args) {

        ServerSocket t_ss = null;
        Socket t_s = null;
        BufferedReader t_br = null;
        String t_lineStr = null;

        while (true) {
            try {
                t_ss = new ServerSocket(9857);
                t_s = t_ss.accept();
                t_br = new BufferedReader(new InputStreamReader(t_s.getInputStream()));
                if ((t_lineStr = t_br.readLine()) != null) {
                    System.out.println(t_lineStr);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }



        if (t_ss != null) {
            try {
                t_ss.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        */

    }

}
