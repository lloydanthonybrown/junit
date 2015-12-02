import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Lloyd on 12/1/2015.
 */
public class FishTank {

    private int numberOfFish = 0;
    private HashMap<String, GoldfishBean> goldfishes;
    private HashMap<String, PirahnaBean> pirahnas;

    public FishTank(){
        goldfishes = new HashMap<String, GoldfishBean>();
        pirahnas = new HashMap<String, PirahnaBean>();
    }

    // Method for adding fish
    // How do I add a fish to the tank itself? Am I adding it to the goldfishes hashmap?
    // What's the index for?
    public void addGoldFish(){

        goldfishes.put("Hansol", ("Blue", 3));
    }

    // Method for removing fish
    public void removeGoldFish(){

    }

    // Method for duplicating fish
    public void duplicateGoldFish(){

    }
}
