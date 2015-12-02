import java.io.Serializable;

/**
 * Created by Lloyd on 12/1/2015.
 */
public class FishBean implements Serializable {
    private int name;
    private int gills;
    private int lungs;

    public FishBean(){

    }

    public FishBean (int name, int gills, int lungs){
        this.name = name;
        this.gills = gills;
        this.lungs = lungs;
    }

    public int getName() {
        return this.name;
    }
    public void setName(int name) {
        this.name = name;
    }
    public int getGills() {
        return this.gills;
    }
    public void setGills(int gills) {
        this.gills = gills;
    }
    public int getLungs() {
        return this.lungs;
    }
    public void setLungs(int lungs) {
        this.lungs = lungs;
    }

}
