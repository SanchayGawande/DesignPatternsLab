package edu.umb.cs680.Hw04;

class HighState implements FanState {

    @Override
    public void turnOn(FanContext fan) {
        System.out.println("Fan is already on (High speed).");
    }

    @Override
    public void turnOff(FanContext fan) {
        System.out.println("Fan is turned off.");
        fan.setState(new OffState());
    }

    @Override
    public void increaseSpeed(FanContext fan) {
        System.out.println("Fan is already on (High speed).");
    }

    @Override
    public void decreaseSpeed(FanContext fan) {
        System.out.println("Fan speed decreased to Medium.");
        fan.setState(new MediumState());
    }

    @Override
    public void toggleSpeed(FanContext fan) {
        System.out.println("Toggling fan speed to Medium.");
        fan.setState(new MediumState());
    }
}


