package com.hobis.works.job150621;

import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;


/**
 * Created by Hobis-PC on 2015-06-21.
 */
@SuppressWarnings({"unused", "Convert2streamapi", "SpellCheckingInspection"})
public class RollServer extends Thread implements Closeable {

    public RollServer(String name, int port) {
        this._name = name;
        this._port = port;
    }

    private String _name = null;
    public String get_name() {
        return this._name;
    }

    private int _port;
    public int get_port() {
        return this._port;
    }

    private boolean _isLoop = true;
    public boolean get_isLoop() {
        return this._isLoop;
    }

    private ServerSocket _server = null;
    public ServerSocket get_server() {
        return this._server;
    }

    private Vector<RollTask> _clients = null;
    public Vector<RollTask> get_clients() {
        return this._clients;
    }
    public int get_clientsLen() {
        if (this._clients == null)
            return 0;

        return this._clients.size();
    }
    public void clear_clients() {
        if (this._clients != null) {
            for (RollTask t_ut : this._clients) {
                RollUtil.close(t_ut);
            }

            this._clients.clear();
            this._clients = null;
        }
    }


    private void p_start_client(Socket cs) {
        if (this._clients == null) {
            this._clients = new Vector<>();
        }
        RollTask t_ut = new RollTask(cs, this._clients);
        t_ut.start();
    }

    private void p_start_msgs() {
        RollUtil.trace(RollUtil.MTL_SYSTEM, "# 서버가 시작됩니다.");
        RollUtil.trace(RollUtil.MTL_SYSTEM, "# 서버-호스트: " + RollUtil.get_hostAddress());
        RollUtil.trace(RollUtil.MTL_SYSTEM, "# 서버-포트: " + this._port);
    }


    @Override
    public void run() {
        p_start_msgs();

        try {
            this._server = new ServerSocket(this._port);

            while (this._isLoop) {
                Socket t_c = this._server.accept();
                this.p_start_client(t_c);
            }
        }
        catch (IOException e) {
            RollUtil.trace(null, e.toString());
        }
    }




    @Override
    public void close() {
        this._isLoop = false;

        RollUtil.close(this._server);
        this._server = null;
    }
}
