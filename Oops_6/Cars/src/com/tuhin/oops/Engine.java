package com.tuhin.oops;

public class Engine {
    String model;
    int rpm;

    public Engine(String model, int rpm) {
        this.model = model;
        this.rpm = rpm;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }
}
