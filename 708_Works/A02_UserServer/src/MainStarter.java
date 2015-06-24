import com.hobis.works.job150621.RollServer;


/**
 * Created by Hobis-PC on 2015-06-21.
 */
@SuppressWarnings("Convert2Lambda")
public final class MainStarter {
    public static void main(String[] args) {
        RollServer t_us = new RollServer("MainServer", 9994);
        t_us.setDaemon(true);
        t_us.start();
        try {
            t_us.join();
        }
        catch (InterruptedException e) {
        }

    }
}
