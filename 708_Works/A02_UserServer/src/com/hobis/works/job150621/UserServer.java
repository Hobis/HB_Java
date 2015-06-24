package com.hobis.works.job150621;

import com.hobis.works.job150621.utils.UserUtil;

import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;


/**
 * Created by Hobis-PC on 2015-06-21.
 */
@SuppressWarnings({"unused", "Convert2streamapi"})
public class UserServer extends Thread implements Closeable {

    public UserServer(String name, int port) {
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

    private final Object _lock = new Object();

    private boolean _isLoop = true;
    public boolean get_isLoop() {
        return this._isLoop;
    }

    private ServerSocket _server = null;
    public ServerSocket get_server() {
        return this._server;
    }

    private Vector<UserTask> _clients = null;
    public Vector<UserTask> get_clients() {
        return this._clients;
    }
    public int get_clientsLen() {
        if (this._clients == null)
            return 0;

        return this._clients.size();
    }
    public void clear_clients() {
        if (this._clients != null) {
            for (UserTask t_ut : this._clients) {
                UserUtil.close(t_ut);
            }

            this._clients.clear();
            this._clients = null;
        }
    }


    private void p_start_client(Socket cs) {
        if (this._clients == null) {
            this._clients = new Vector<>();
        }
        UserTask t_ut = new UserTask(cs);
        this._clients.add(t_ut);
        t_ut.start();
    }


    @Override
    public void run() {
        while (this._isLoop) {
            try {
                this._server = new ServerSocket();
                Socket t_c = this._server.accept();
                this.p_start_client(t_c);
            }
            catch (IOException e) {
            }
        }
    }




    @Override
    public void close() {
        this._isLoop = false;

        UserUtil.close(this._server);
        this._server = null;
    }
}
