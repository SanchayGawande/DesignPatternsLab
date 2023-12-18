package edu.umb.cs680.Hw12;
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
            this.mileage= mileage;
            this.price= price;
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

        public float getPrice(){
            return price;
        }

    public int getDominationCount() {
        return dominationCount;
    }


    public void setDominationCount(List<Car> cars) {
        int count = 0;
        for (Car otherCar : cars) {
            if (dominates(otherCar)) {
                dominationCount++;
            }
        }

    }

    private boolean dominates(Car otherCar) {
        boolean otherPriceBetterOrEqual = this.price <= otherCar.getPrice();
        boolean otherYearBetterOrEqual = this.year <= otherCar.getYear();
        boolean otherMileageBetterOrEqual = this.mileage >= otherCar.getMileage();

        boolean atLeastOneAspectBetter =
                (this.price < otherCar.getPrice()) ||
                        (this.year > otherCar.getYear()) ||
                        (this.mileage < otherCar.getMileage());

        return otherPriceBetterOrEqual && otherYearBetterOrEqual && otherMileageBetterOrEqual && atLeastOneAspectBetter;
    }


    public static void main(String[] args) {

    }


}

