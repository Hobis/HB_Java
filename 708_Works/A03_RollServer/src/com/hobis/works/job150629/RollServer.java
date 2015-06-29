package com.hobis.works.job150629;

import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by snag on 2015-06-29.
 */
@SuppressWarnings("unused")
public class RollServer extends Thread implements Closeable {

    public RollServer(String name, int port) {
        this.setName(name);
        this._port = port;
        this._isLoop = true;
    }

    private int _port;
    private boolean _isLoop = false;
    private ServerSocket _ss = null;


    // ::
    private void p_serverLoop() {

        try {
            this._ss = new ServerSocket();

            while (_isLoop) {
                Socket t_cs = this._ss.accept();
            }
        }

        catch (IOException e) {
        }

    }








    @Override
    public void run() {
        RollUtil.trace("서버가 시작됩니다.");
        RollUtil.trace("서버-호스트: " + RollUtil.get_hostAddress());
        RollUtil.trace("서버-포트: " + this._port);

        //p_serverLoop();
    }

    @Override
    public void close() {

    }
}
