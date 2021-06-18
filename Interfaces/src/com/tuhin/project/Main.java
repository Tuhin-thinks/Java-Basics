package com.tuhin.project;

public class Main {
    public static void main(String[] args) {
        CarInterface carInterface = new ElectricCar("Tesla");
        carInterface.start();
        carInterface.move(60);

        CarInterface fossilCarInterface = new FossiFuelCar("Mercedes");
        fossilCarInterface.start();
        fossilCarInterface.move(150);
    }
}
