package hu.nagy.kristof.carrental;

public class Car {
    private String brand;
    private String model;
    private Integer year;
    private Integer pricePerDay;
    private Boolean borrowable;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getPricePerDay() {
        return pricePerDay;
    }

    public Boolean getBorrowable() {
        return borrowable;
    }

    public Car(String brand, String model, Integer year, Integer pricePerDay, Boolean borrowable) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.pricePerDay = pricePerDay;
        this.borrowable = borrowable;
    }


}
