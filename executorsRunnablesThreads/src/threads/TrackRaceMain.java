package threads;
/**
 * Created by Lloyd on 12/7/2015.
 */
public class TrackRaceMain {
    public static void main(String[] args){
        TrackSprinterRunnable sprinter = new TrackSprinterRunnable();
        Thread mcallisterThread = new Thread(sprinter,"McAllister");
        Thread rikkiThread = new Thread(sprinter,"Rikki");

        try {

        }
        catch (Exception e){
            e.printStackTrace();
        }
        // Nasty path: make a new thread and pass it null for the name. See what happens.
                // Results: error - Exception in thread "main" java.lang.NullPointerException: name cannot be null
//        Thread nullThread = new Thread(sprinter,null);

        // Nasty path: run more threads than just your normal 2.
        // Results: No errors. It worked! All 4 threads ran.
//        Thread danThread = new Thread(sprinter,"Dan");
//        Thread lloydThread = new Thread(sprinter,"Lloyd");
//        Thread garyThread = new Thread(sprinter,"Gary");
//        Thread daneThread = new Thread(sprinter,"Dane");
//        Thread benThread = new Thread(sprinter,"Ben");
//        Thread jaredThread = new Thread(sprinter,"Jared");

        //Begin the threads.
        rikkiThread.start();
        System.out.println("Started the rikkiThread.");
        mcallisterThread.start();
        System.out.println("Started the mcallisterThread.");
        // Actually starting the nullThread for a nasty path.
//        nullThread.start();
        // Actually starting these two threads for another nasty path.
//        danThread.start();
//        lloydThread.start();
    }

    // Happy/Nasty paths: see what you can do with a thread pool. See what Alberto does for this.
    // Happy/Nasty paths: play with executors, see what happens, test their boundaries. Have a separate class for this?

    // Happy/Nasty paths: start a thread with a runnable (refer to the book). See what it can do.
    // Happy/Nasty paths: Cross-lock for java threads, runnables and executors.
}
