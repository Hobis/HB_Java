package hb.tools;

/**
 * Created by Hobis-PC on 2015-06-24.
 */
@SuppressWarnings({"unused", "UnusedAssignment"})
public final class HB_ThreadTool {
    private HB_ThreadTool() {
    }

    public static Thread create(
            Runnable target,
            String name,
            boolean isDaemon,
            boolean isStart) {

        Thread t_th = null;
        if (name == null) {
            t_th = new Thread(target);
        }
        else {
            t_th = new Thread(target, name);
        }
        t_th.setDaemon(isDaemon);
        t_th.start();
        return t_th;
    }

    public static Thread create(
            Runnable target,
            String name,
            boolean isDaemon) {

        return create(target, name, isDaemon, true);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }

}
