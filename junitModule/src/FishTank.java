import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Lloyd on 12/1/2015.
 */
public class FishTank {
    private int count;

    private String finalGoal;
    private HashMap<String, GoldfishBean> goldfishes;
    private ArrayList piranhas;

    public FishTank(){
        goldfishes = new HashMap<String, GoldfishBean>();
        piranhas = new ArrayList();
    }

    public String getFinalGoal() {
        return finalGoal;
    }
    public void setFinalGoal(String finalGoal) {
        this.finalGoal = finalGoal;
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
    public void addGoldfish(GoldfishBean aGoldfish){
        // Verify that the given key information is not null.
        String key = aGoldfish.getName();
        goldfishes.put(key, aGoldfish);
        count++;
    }

    public void addPiranha(int index, PiranhaBean aPiranha){
        try{
            piranhas.add(index, aPiranha);
            count++;
        }
        catch (IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException();
        }

    }

    // Method for removing fish
//    public void removeGoldFish(GoldfishBean aGoldfish){
//        String key = aGoldfish.getName();
//        goldfishes.remove(key, aGoldfish);
//        count--;
//    }

    // Would this be a better solution than what I currently have?
    public boolean removeGoldfish(String name){
        if (goldfishes.containsKey(name)){
            goldfishes.remove(name);
            return true;
        }
        else
            return false;
    }
}
