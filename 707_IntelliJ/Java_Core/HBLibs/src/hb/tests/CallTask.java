package hb.tests;

import java.io.*;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/**
 * Created by Hobis-PC on 2015-07-05.
 */
@SuppressWarnings({"unused", "UnusedAssignment"})
public final class CallTask extends Thread {

    // -
    private static Hashtable<String, CallTask> t_rtss = null;

    // -
    private static Vector<CallTask> _rts = null;
    // ::
    public static Vector<CallTask> get_rts() {
        return _rts;
    }

    // ::
    public static void removeAll() {
        if (_rts == null) return;

        Enumeration<CallTask> t_enu = _rts.elements();
        while (t_enu.hasMoreElements()) {
            CallTask t_rt = t_enu.nextElement();
            t_rt.p_close();
        }

        _rts.clear();
        _rts = null;
    }

    // ::
    public static void remove(CallTask rt) {
        if (_rts == null) return;

        rt.p_close();
        _rts.remove(rt);

        if (_rts.isEmpty()) {
            _rts.clear();
            _rts = null;
        }
    }

    // ::
    public static void addStart(String name, Socket cs) {
        CallTask t_rt = new CallTask(name, cs);
        t_rt.start();

        if (_rts == null) {
            _rts = new Vector<>();
        }
        _rts.add(t_rt);
        CallHelper.trace(String.valueOf(_rts.size()));
    }

    // ::
    public static void sendAll(String msg) {
        if (_rts == null) return;

        CallHelper.trace(msg);
        Enumeration<CallTask> t_enu = _rts.elements();
        while (t_enu.hasMoreElements()) {
            CallTask t_rt = t_enu.nextElement();
            try {
                t_rt._bw.write(msg);
                t_rt._bw.newLine();
                t_rt._bw.flush();
            }
            catch (Exception e) {
            }
        }
    }









    // ##
    private CallTask(String name, Socket cs) {
        this.setName(name);
        this.setDaemon(true);
        this._cs = cs;
    }
    private Socket _cs = null;
    private BufferedReader _br = null;
    private BufferedWriter _bw = null;


    // ::
    private void p_close() {
        try {
            this._cs.close();
            this._cs = null;
        }
        catch (Exception e) {
        }

        try {
            this._br.close();
            this._br = null;
        }
        catch (Exception e) {
        }

        try {
            this._bw.close();
            this._bw = null;
        }
        catch (Exception e) {
        }
    }

    // ::
    private void p_loop() {
        if (this._cs == null) return;

        try {
            this._br = new BufferedReader(new InputStreamReader(this._cs.getInputStream()));
            this._bw = new BufferedWriter(new OutputStreamWriter(this._cs.getOutputStream()));
            //CallHelper.trace("# ~~~~11");
            String t_ls = null;
            while ((t_ls = this._br.readLine()) != null) {
                sendAll(t_ls);
            }
            //CallHelper.trace("# ~~~~22");
        }
        catch (Exception e) {
            //CallHelper.trace("# 예외가 발생을 합니까");
        }

        remove(this);
    }

    @Override
    public void run() {
        this.p_loop();
    }
}
