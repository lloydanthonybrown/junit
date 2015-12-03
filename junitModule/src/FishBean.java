import java.io.Serializable;

/**
 * Created by Lloyd on 12/1/2015.
 */
public class FishBean implements Serializable {
    private String name;
    private int gills;
    private int lungs;

    public FishBean(){

    }

    public FishBean (String name, int gills, int lungs){
        this.name = name;
        this.gills = gills;
        this.lungs = lungs;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
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
