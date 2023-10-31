package edu.umb.cs680.Hw04;

class OffState implements FanState {

        @Override
        public void turnOn(FanContext fan) {
            System.out.println("Fan is turned on (Low speed).");
            fan.setState(new LowState());
        }

        @Override
        public void turnOff(FanContext fan) {
            System.out.println("Fan is already off.");
        }

        @Override
        public void increaseSpeed(FanContext fan) {
            System.out.println("Fan is turned on (Low speed).");
            fan.setState(new LowState());
        }

        @Override
        public void decreaseSpeed(FanContext fan) {
            System.out.println("Fan is already turned off.");
        }

       @Override
       public void toggleSpeed(FanContext fan) {
            System.out.println("Toggling fan speed to Low.");
            fan.setState(new LowState());

    }
}
