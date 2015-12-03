/**
 * Created by Lloyd on 12/1/2015.
 */
public class PiranhaBean extends FishBean{
    private boolean hasTeeth;
    private String waterPreference;
    private String foodPreference;

    public PiranhaBean(String name, int gills, int lungs, boolean hasTeeth, String waterPreference, String foodPreference ){
        super(name, gills, lungs);
        this.hasTeeth = hasTeeth;
        this.waterPreference = waterPreference;
        this.foodPreference = foodPreference;
    }
    public String getFoodPreference() {
        return foodPreference;
    }
    public void setFoodPreference(String foodPreference) {
        this.foodPreference = foodPreference;
    }
    public String getWaterPreference() {
        return waterPreference;
    }
    public void setWaterPreference(String waterPreference) {
        this.waterPreference = waterPreference;
    }
    public boolean isHasTeeth() {
        return hasTeeth;
    }
    public void setHasTeeth(boolean hasTeeth) {
        this.hasTeeth = hasTeeth;
    }

}
