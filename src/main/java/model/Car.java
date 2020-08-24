package model;

public class Car {
    private Integer id;
    private String make;
    private String model;
    private Integer yearOfCar;
    private String color;
    private String vin;

    public Car() {

    }

    public Car(String make, String model, Integer yearOfCar, String color, String vin) {
        this.make = make;
        this.model = model;
        this.yearOfCar = yearOfCar;
        this.color = color;
        this.vin = vin;
    }

    public Car(Integer id, String make, String model, Integer yearOfCar, String color, String vin) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.yearOfCar = yearOfCar;
        this.color = color;
        this.vin = vin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYearOfCar() {
        return yearOfCar;
    }

    public void setYearOfCar(Integer yearOfCar) {
        this.yearOfCar = yearOfCar;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Car ID: " + this.getId() + " ")
                .append("Make: " + this.getMake() + " ")
                .append("Model: " + this.getModel() + " ")
                .append("Color: " + this.getColor() + " ")
                .append("Year: " + this.getYearOfCar());
        return stringBuilder.toString();
    }
}
