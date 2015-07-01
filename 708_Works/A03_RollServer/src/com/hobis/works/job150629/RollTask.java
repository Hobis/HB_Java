package com.hobis.works.job150629;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;


/**
 * Created by snag on 2015-07-01.
 */
@SuppressWarnings({"unused", "Convert2Diamond"})
public class RollTask extends Thread implements Closeable {

    private static Vector<RollTask> _rts = null;
    public static Vector<RollTask> get_rts() {
        return _rts;
    }

    public static void remove_all() {
        if (_rts == null) return;

        Enumeration<RollTask> t_enu = _rts.elements();
        while (t_enu.hasMoreElements()) {
            RollTask t_rt = t_enu.nextElement();
            t_rt.close();
        }

        _rts = null;
    }

    public static void remove_at(int i) {
        if (_rts == null) return;

        _rts.remove(i);
        if (_rts.isEmpty()) {
            _rts = null;
        }
    }

    public static void remove(RollTask rt) {
        if (_rts == null) return;

        _rts.remove(rt);
        if (_rts.isEmpty()) {
            _rts = null;
        }
    }

    public static void add(Socket cs) {
        RollTask t_rt = new RollTask(cs);

        if (_rts == null) {
            _rts = new Vector<RollTask>();
        }
        _rts.add(t_rt);
    }






    // ::
    private RollTask(Socket cs) {
        this._isLoop = true;
        this._cs = cs;
    }

    private boolean _isLoop = false;
    private Socket _cs = null;
    private Scanner _scan = null;



    // ::
    private void p_loop() {
        try {
            _scan = new Scanner(_cs.getInputStream());
        }
        catch (IOException e) {
            this.close();
            return;
        }

        while (_scan.hasNextLine()) {
            String t_ls = _scan.nextLine();
            RollUtil.trace("t_ls: " + t_ls);
        }
    }


    @Override
    public void run() {
        p_loop();
    }

    @Override
    public void close() {
        _isLoop = false;

        try {
            _cs.close();
            _cs = null;
        }
        catch (Exception e) {
        }

        try {
            _scan.close();
            _scan = null;
        }
        catch (Exception e) {
        }

        remove(this);
    }
}
