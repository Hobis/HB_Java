package com.hobis.works.job150621;

import java.util.Vector;

/**
 * Created by snag on 2015-06-24.
 */
@SuppressWarnings("unused")
public final class RollChecker extends Thread {

    public RollChecker(RollServer rs) {
        this._rs = rs;
    }

    private RollServer _rs = null;
    public void kill() {
        _rs = null;
    }

    @Override
    public void run() {
        while (_rs != null) {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
            }

            Vector<RollTask> t_clients = this._rs.get_clients();
            if (t_clients != null) {
                RollUtil.trace("# 현재 접속 수: " + t_clients.size());
            }
            else {
                RollUtil.trace("# 현재 접속 수: " + 0);
            }
        }
    }
}
