import java.io.Serializable;

/**
 * Created by Lloyd on 12/1/2015.
 */
public class FishBean implements Serializable {
    private int fins;
    private int gills;
    private int lungs;

    public FishBean (int fins, int gills, int lungs){

    }

    public int getFins() {
        return fins;
    }

    public void setFins(int fins) {
        this.fins = fins;
    }

    public int getGills() {
        return gills;
    }

    public void setGills(int gills) {
        this.gills = gills;
    }

    public int getLungs() {
        return lungs;
    }

    public void setLungs(int lungs) {
        this.lungs = lungs;
    }


}
