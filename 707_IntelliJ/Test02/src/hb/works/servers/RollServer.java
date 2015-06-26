package hb.works.servers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/**
 * Created by snag on 2015-06-25.
 */
@SuppressWarnings("unused")
public class RollServer extends Thread {
/*
    public static Vector<RollServer> _rss = null;
    public static Vector<RollServer> get_rss() {
        return _rss;
    }

    public static int get_rssLen() {
        if (_rss == null) {
            return 0;
        }
        else {
            return _rss.size();
        }
    }

    public static void add_rs(RollServer rs) {
        if (_rss == null) {
            _rss = new Vector<>();
        }
        _rss.add(rs);
    }

    public static void create_rs() {

    }*/





    private RollServer(String name, int port) {
        this.setName(name);
        this.setDaemon(true);
        this._port = port;
        try {
            this._ss = new ServerSocket();
        }
        catch (IOException e) {
        }
    }
    private int _port;
    private boolean _isLoop = true;

    private ServerSocket _ss = null;


    // ::
    private void p_loop() {
        while (this._isLoop) {

        }
    }



    @Override
    public void run() {
    }
}
