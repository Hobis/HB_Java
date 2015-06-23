package com.hobis.testa;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Hobis-PC on 2015-06-19.
 */
public final class RollServer extends Thread {

    public RollServer(int port) {
        try {
            _ss = new ServerSocket(port);
        }
        catch (IOException e) {
        }
    }

    private ServerSocket _ss = null;
    public ServerSocket get_serverSocket() {
        return _ss;
    }

    private boolean _isLoop = true;


    // ::
    private void p_loop() {
        while (_isLoop) {
            try {
                Socket t_cs = _ss.accept();
                MainStarter.get_rform().append_txt(RollUtil.MT_SYSTEM, "연결이 되었습니다.");

                RollTask t_rtask = new RollTask(t_cs);
                t_rtask.start();

            }
            catch (IOException e) {
            }
        }
    }


    // ::
    public void kill() {
        if (_ss != null) {
            _isLoop = false;

            try {
                _ss.close();
            }
            catch (Exception e) {
            }
            _ss = null;
        }
    }

    @Override
    public void run() {
        if (_ss != null) {
            p_loop();
        }
    }






}
