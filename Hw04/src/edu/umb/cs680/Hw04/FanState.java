package edu.umb.cs680.Hw04;

interface FanState {
    void turnOn(FanContext fan);
    void turnOff(FanContext fan);
    void increaseSpeed(FanContext fan);
    void decreaseSpeed(FanContext fan);
    void toggleSpeed(FanContext fan);
}
