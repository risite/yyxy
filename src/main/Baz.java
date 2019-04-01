package main;

public class Baz{
    private String type;
    private Double typeValue;

    public Baz(String type, Double typeValue) {
        this.type = type;
        this.typeValue = typeValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(Double typeValue) {
        this.typeValue = typeValue;
    }
}
