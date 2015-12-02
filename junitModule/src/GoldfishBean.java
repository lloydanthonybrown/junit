/**
 * Created by Lloyd on 12/1/2015.
 */
public class GoldfishBean extends FishBean{
    private String color;
    private String nemesis;
    private int size;

    public GoldfishBean(int fins, int gills, int lungs, String color, String nemesis, int size){
        super(fins, gills, lungs);
        this.color = color;
        this.size = size;
        this.nemesis = nemesis;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getNemesis() {
        return nemesis;
    }
    public void setNemesis(String nemesis) {
        this.nemesis = nemesis;
    }

}
