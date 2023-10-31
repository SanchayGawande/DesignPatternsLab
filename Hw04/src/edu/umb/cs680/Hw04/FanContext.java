package edu.umb.cs680.Hw04;

public class FanContext {
    private FanState state;

    public FanContext() {
        state = new OffState();
    }

    public void setState(FanState state) {
        this.state = state;
    }

    public void turnOn() {
        state.turnOn(this);
    }

    public void turnOff() {
        state.turnOff(this);
    }

    public void increaseSpeed() {
        state.increaseSpeed(this);
    }

    public void decreaseSpeed() {
        state.decreaseSpeed(this);
    }
    public FanState getState() {
        return state;
    }

    public void displayState() {
        System.out.println("Fan is in " + state.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        FanContext fan = new FanContext();

        fan.turnOn();
        fan.increaseSpeed();
        fan.increaseSpeed();
        fan.decreaseSpeed();
        fan.turnOff();
    }

    public void toggleSpeed() {
        FanState currentState = getState();
        if (currentState instanceof LowState) {
            setState(new MediumState());
        } else if (currentState instanceof MediumState) {
            setState(new HighState());
        } else if (currentState instanceof HighState) {
            setState(new OffState());
        }
    }

}