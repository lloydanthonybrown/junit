package threads;
/**
 * Created by Lloyd on 12/7/2015.
 */
public class TrackSprinterRunnable implements Runnable{
    public static String champion;
    public void race(){
        for(int distance=1;distance<=200;distance++){
            System.out.println(Thread.currentThread().getName() + " has run " + distance + " meters so far.");
            //check the isRaceWon condition, break if complete.
            boolean isRaceWon = this.findIfRaceIsComplete(distance);
            if(isRaceWon){
                System.out.println("The race is over! Let's watch the losers. ");
                break;
            }

            // Nasty path: make the thread sleep for a negative/null number. What happens?
            // Results: No errors...which is super weird. Both threads finished at the exact same time. Which is
            // also super weird.
            try {
                if (Thread.currentThread().getName() == "Rikki") {
                    Thread.currentThread().sleep(-100);
                }
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }

            // Nasty path: what about trying to use the getName() to access a name that doesn't exist?
            // Results: No errors, nothing was affected.
            try {
                if (Thread.currentThread().getName() == "Bobby") {
                    Thread.currentThread().sleep(1000000);
                }
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }

            // Nasty path: put one of the threads to sleep for a long time.
            // Results: No errors. Varying. Thread doesn't get put to sleep, apparently.
            try {
                if (Thread.currentThread().getName() == "Rikki") {
                    Thread.currentThread().sleep(1000000);
                }
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }

    // Happy path: The race is over when one thread finishes. Return a message signifying the champion.
    // Results: depends, but Rikki seems to win a lot. No errors.
    private boolean findIfRaceIsComplete(int totalDistanceCovered){
        boolean isRaceWon = false;
        if((TrackSprinterRunnable.champion == null)&&(totalDistanceCovered == 200)){
            String championName = Thread.currentThread().getName();
            TrackSprinterRunnable.champion = championName; //setting the champion name)
            System.out.println("The champion is: "+ TrackSprinterRunnable.champion + "! Congratulations!" );
            isRaceWon = true;
        }
        else if(TrackSprinterRunnable.champion == null){
            isRaceWon = false;
        }
        else if(TrackSprinterRunnable.champion == null){
            isRaceWon=true;
        }
        return isRaceWon;
    }
    @Override
    public void run(){
        this.race();
    }
}
