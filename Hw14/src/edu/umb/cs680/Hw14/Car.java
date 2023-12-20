package edu.umb.cs680.Hw14;
import java.util.List;

public class Car {
    private String make;
    private String model;
    private int year;
    private int mileage;
    private float price;
    private int dominationCount;

    public Car(String make, String model, int year, int mileage, float price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    public float getPrice() {
        return price;
    }

    public int getDominationCount() {
        return dominationCount;
    }

    public void setDominationCount(List<Car> cars) {
        dominationCount = 0;
        for (Car variantCar : cars) {
            if (dominates(variantCar)) {
                dominationCount++;
            }
        }
    }

    private boolean dominates(Car variantCar) {
        boolean variantPriceIsBetterOrEqual = this.price >= variantCar.getPrice();
        boolean variantYearIsBetterOrEqual = this.year <= variantCar.getYear();
        boolean variantMileageIsBetterOrEqual = this.mileage >= variantCar.getMileage();

        boolean LeastOneIsBetter = (this.price > variantCar.getPrice()) ||
                (this.year < variantCar.getYear()) ||
                (this.mileage < variantCar.getMileage());
        return variantPriceIsBetterOrEqual && variantYearIsBetterOrEqual && variantMileageIsBetterOrEqual && LeastOneIsBetter;
    }

    public static void main(String[] args) {

    }
}


