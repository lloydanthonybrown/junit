import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Lloyd on 12/1/2015.
 */
public class FishTank {
    private int count;
    private HashMap<String, GoldfishBean> goldfishes;
    private HashMap<String, PirahnaBean> pirahnas;

    public FishTank(){
        goldfishes = new HashMap<String, GoldfishBean>();
        pirahnas = new HashMap<String, PirahnaBean>();
    }

    public int getCount() {
        return count;
    }

    public int returnGHashMapSize(){
        return goldfishes.size();
    }

    // Method for adding fish
    // How do I add a fish to the tank itself? Am I adding it to the goldfishes hashmap?
    // What's the index for?
    public void addGoldFish(GoldfishBean aGoldfish){
        // Verify that the given key information is not null.
        if(){
            String key = aGoldfish.getName();
            goldfishes.put(key, aGoldfish);
            count++;

        }
//        goldfishes.put("Hansol", ("Blue", 3));
    }

    // Method for removing fish
    public void removeGoldFish(){

    }

    // Method for duplicating fish
    public void duplicateGoldFish(){

    }
}
