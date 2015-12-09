package threads;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/**
 * Created by Lloyd on 12/8/2015.
 */
// I actually have no idea how this executor is accessing my TrackSprinterRunnable class.
public class ExecutorsLloyd {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });

        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }

        // Testing some stuff out from Barneys example.

        Executor anExecutor = Executors.newCachedThreadPool();
        for(int threadCnt = 0; threadCnt < 3; threadCnt++){
            TrackSprinterRunnable aSillyRunnable =
                    new TrackSprinterRunnable();
            anExecutor.execute(aSillyRunnable);
        }
        try {
            Thread.sleep(5000);
            System.out.println("Done Sleeping");
            for(int threadCnt = 0; threadCnt < 3; threadCnt++){
                TrackSprinterRunnable aSimpleRunnable = new TrackSprinterRunnable();
                anExecutor.execute(aSimpleRunnable);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

