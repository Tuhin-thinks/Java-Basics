package com.tuhin.oops;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine("Renault", 8000);
        Car mercedes = new Car("Mercedes AMG", 2, "silver", engine);

        System.out.println("Engine model: " + mercedes.getEngine().getModel());
    }
}