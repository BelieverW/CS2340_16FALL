package model;

/**
 * Created by rober_000 on 10/11/2016.
 */
public enum WaterType {
    BOTTLED("Bottled"), WELL("Well"), STREAM("Stream"), LAKE("Lake"), SPRING("Spring"), OTHER("Other");
    private final String type;
    WaterType(String type) {this.type = type;}

    public String getWaterType() { return this.type; }
    public String toString() { return this.type;}


}
