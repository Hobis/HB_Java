import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/**
 * Created by snag on 2015-07-01.
 */
@SuppressWarnings({"unused", "UnusedAssignment"})
public final class MainStarter {

    // ::
    private static final class _RollTask extends Thread {

        public static Vector<_RollTask> _rts = null;
        public static Vector<_RollTask> get_rts() {
            return  _rts;
        }

        public static void add(Socket cs) {
            _RollTask t_rt = new _RollTask(cs);

            if (_rts == null) {
                _rts = new Vector<>();
            }
            _rts.add(t_rt);
        }




        // ::
        private _RollTask(Socket cs) {
            this._cs = cs;
        }
        private Socket _cs = null;
        private BufferedReader _br = null;


        @Override
        public void run() {
            try {
                _br = new BufferedReader(new InputStreamReader(_cs.getInputStream()));

                while (_br != null) {
                    String t_ls = null;
                    while ((t_ls = _br.readLine()) != null) {
                        System.out.println("t_ls: " + t_ls);
                    }
                }
            }
            catch (IOException e) {
            }

            try {
                _br.close();
                _br = null;
            }
            catch (Exception e) {
            }

            try {
                _cs.close();
                _cs = null;
            }
            catch (Exception e) {
            }
        }

        // ::
        public void close() {

        }
    }


    public static void main(String[] args) {
        ServerSocket t_ss = null;

        try {
            t_ss = new ServerSocket();
        }
        catch (IOException e) {
        }


        Socket t_cs = null;
        BufferedReader t_br = null;

        while (true) {
            try {
                t_cs = t_ss.accept();
                t_br = new BufferedReader(new InputStreamReader(t_cs.getInputStream()));

                System.out.println("접속이 되었습니다~~");

            }
            catch (IOException e) {
                break;
            }
        }


        try {
            t_ss.close();
            t_ss = null;
        }
        catch (Exception e) {
        }

    }

}



