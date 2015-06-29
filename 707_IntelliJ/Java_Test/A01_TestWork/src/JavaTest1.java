import java.util.Objects;

/**
 * Created by snag on 2015-06-29.
 */
@SuppressWarnings({"Convert2Lambda", "UnusedAssignment", "UnusedParameters", "unused"})
public final class JavaTest1 {


    private static Object _lock = new Object();


    private static void p_llp(final long sleep) {
        Thread t_th = null;
        t_th = new Thread(new Runnable() {



            private int _countEnd = 100;
            private int _count = 0;

            @Override
            public void run() {
                while (_count < _countEnd) {
                    try {
                        Thread.sleep(sleep);
                    }
                    catch (InterruptedException e) {
                    }

                    System.out.println("Thread: " + _count);

                    _count++;
                }
            }
        });
        t_th.start();


    }

    public static void main(String[] args) {

        Thread t_th = null;


        t_th = new Thread(new Runnable() {
            private int _countEnd = 100;
            private int _count = 0;

            @Override
            public void run() {
                while (_count < _countEnd) {
                //while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e) {
                    }

                    System.out.println("Thread: " +Thread.currentThread().isInterrupted() + + _count);

                    _count++;
                }
            }
        });
        t_th.start();
        //System.out.println(t_th.isInterrupted());


        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
        }

        System.out.println("~~~~~~~~~");
        t_th.interrupt();




/*
        t_th = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e) {
                    }
                }
            }
        });
        t_th.start();*/
        //System.out.println(t_th.isInterrupted());
        //*/






/*
        for (int i = 0; i < 10; i++) {
            p_llp(100);
        }*/



/*
        try {
            Thread.sleep(Long.MAX_VALUE);
        }
        catch (InterruptedException e) {
        }*/

        //Thread.holdsLock(_lock);
/*
        try {
            _lock.wait();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

}
