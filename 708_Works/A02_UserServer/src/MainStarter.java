import com.hobis.works.job150621.RollChecker;
import com.hobis.works.job150621.RollServer;


/**
 * Created by Hobis-PC on 2015-06-21.
 */
@SuppressWarnings({"Convert2Lambda", "SpellCheckingInspection", "unused"})
public final class MainStarter {
    public static void main(String[] args) {
        RollServer t_server = new RollServer("MainServer", 9994);
        t_server.setDaemon(true);
        t_server.start();

        RollChecker t_rcheck = new RollChecker(t_server);
        //t_rcheck.start();

        try {
            t_server.join();
        }
        catch (InterruptedException e) {
        }

    }
}
