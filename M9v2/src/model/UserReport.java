package model;

/**
 * Created by Daniel_RICE on 21/10/2016.
 */
public class UserReport extends Report {
    private WaterType watertype;
    private WaterCondition watercondition;

    public UserReport(String u, String title, String date, String location, WaterType watertype, WaterCondition watercondition) {
        super(u, title, date, location);
        this.watertype = watertype;
        this.watercondition = watercondition;
    }

    public UserReport(String u, String title, String location, WaterType watertype, WaterCondition watercondition) {
        super(u, title, location);
        this.watertype = watertype;
        this.watercondition = watercondition;
    }

    public WaterType getWaterType() {
        return watertype;
    }

    public void setWaterType(WaterType watertype) {
        this.watertype = watertype;
    }

    public WaterCondition getWaterCondition() {
        return watercondition;
    }

    public void setWaterConditon(WaterCondition watercondition) {
        this.watercondition = watercondition;
    }
}
