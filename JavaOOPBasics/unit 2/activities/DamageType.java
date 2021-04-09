package activities;

public enum DamageType {
    NORMAL("Red");
    HEAVY("Green");
    ION("Blue");

    private String color;

    private DamageType(String color){
        this.color = color;
    }

    public String getColor(){
        return color
    }
}
