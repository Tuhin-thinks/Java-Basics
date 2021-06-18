package com.tuhin.project;

public class FossiFuelCar implements CarInterface{
    private String name;

    public FossiFuelCar(String name) {
        this.name = name;
    }

    @Override
    public void start() {
        System.out.println("Explosion is cylinder caused the engine ti start");
    }

    @Override
    public void move(int speed) {
        System.out.println(this.getName() + " is moving at " + speed + " mph");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
