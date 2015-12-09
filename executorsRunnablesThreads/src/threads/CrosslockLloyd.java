package threads;
/**
 * Created by Lloyd on 12/8/2015.
 */
// Based on the SyncDemo.java class.
public class CrosslockLloyd {
    private static int count = 0;

    public static synchronized void inCount(){
        count ++;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    // Why would I increase the count variable here?
                    try{
                        count++;
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                    inCount();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    // What I used to have here.
//                    count++;
                    inCount();
                }
            }
        });

        t1.start();
        t2.start();
        // Works similar to putting the thread the sleep. If I take this try/catch block out, it completely
        // keeps the threads from running, for some reason.
        try {
            t1.join();
        }catch (InterruptedException e){
            e.printStackTrace();

        }
        // It doesn't matter if I have a join method for the second thread, because the first join method caused the
        // second thread to complete first, so it would be redundant here to tell the second thread to pause for the
        // first to finish (because the second is already done).
        try {
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();

        }
        // Print out the overall value achieved by the only variable in this class.
        System.out.println("The value is: " + count);
    }
}
