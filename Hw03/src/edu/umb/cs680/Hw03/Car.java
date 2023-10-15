package edu.umb.cs680.Hw03;

public class Car {
        private String make;
        private String model;
        private int year;
        private int milage;
        private float price;

        public Car(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
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

        public int getMilage() {
            return milage;
        }

        public float getPrice(){
            return price;
        }

    public static void main(String[] args) {

    }


}

