package model;

/**
 * Created by rober_000 on 10/11/2016.
 */
public enum WaterCondition {
    WASTE("Waste"), TCLEAR("Treatable-Clear"), TMUDDY("Treatable-Muddy"), POTABLE("Potable"), UNKNOWN("Unknown");
    private final String condition;
    WaterCondition(String condition) { this.condition = condition; }
    public String getWaterConditon() { return condition; }
    public String toString() { return condition; }
}
