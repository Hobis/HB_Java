package com.hobis.servers.chatServer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Created by snag on 2015-06-19.
 */
public final class ServerManager extends Thread {

    // ::
    public ServerManager(int port) {
        this._port = port;
        this.setDaemon(true);
    }

    private static String _sip = null;
    public static String get_sip() {
        if (_sip == null) {
            try {
                _sip = InetAddress.getLocalHost().getHostAddress();
            }
            catch (Exception e) {
            }
        }

        return _sip;
    }

    private int _port;
    private ServerSocket _ss = null;


    private boolean _isLoop = true;
    public boolean get_isLoop() {
        return _isLoop;
    }


    // ::
    private void p_loopStart() {
        try {
            _ss = new ServerSocket();

            while (_isLoop) {
                Socket t_cs = _ss.accept();
                System.out.println("ÇÑ¸í µé¾î¿È");
            }
        }
        catch (Exception e) {
        }

        try {
            _ss.close();
        }
        catch (Exception e) {
        }
    }

    // ::
    public void dispose() {
    }


    @Override
    public void run() {
        p_loopStart();
    }


}
