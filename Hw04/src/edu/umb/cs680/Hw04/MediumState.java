package edu.umb.cs680.Hw04;

class MediumState implements FanState {
    @Override
    public void turnOn(FanContext fan) {
        System.out.println("Fan is already on (Medium speed).");
    }

    @Override
    public void turnOff(FanContext fan) {
        System.out.println("Fan is turned off.");
        fan.setState(new OffState());
    }

    @Override
    public void increaseSpeed(FanContext fan) {
        System.out.println("Fan speed increased to High.");
        fan.setState(new HighState());
    }

    @Override
    public void decreaseSpeed(FanContext fan) {
        System.out.println("Fan speed decreased to Low.");
        fan.setState(new LowState());
    }

    @Override
    public void toggleSpeed(FanContext fan) {
        System.out.println("Toggling fan speed to Low.");
        fan.setState(new LowState());
    }
}
