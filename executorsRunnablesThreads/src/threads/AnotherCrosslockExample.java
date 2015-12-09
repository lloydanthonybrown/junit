package threads;

/**
 * Created by Lloyd on 12/8/2015.
 */
public class AnotherCrosslockExample extends Thread{
    public static Object thingOne = new Object();
    public static Object thingTwo = new Object();

@Override
public void run() {
    synchronized (thingOne) {
//            System.out.println("First thread accessing thingOne");
            try {
                Thread.sleep(50);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (thingTwo) {
//                System.out.println("First thread accessing thingTwo");
            }
        }

        synchronized (thingTwo) {
//            System.out.println("Second thread accessing thingTwo");
            try {
                Thread.sleep(50);
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            synchronized (thingOne) {
//                System.out.println("Second thread accessing thingOne");
            }
        }
    }

    public static void main(String[] args) {
        AnotherCrosslockExample disaster1 = new AnotherCrosslockExample();
        AnotherCrosslockExample disaster2 = new AnotherCrosslockExample();
        disaster1.start();
        disaster2.start();
    }
}
