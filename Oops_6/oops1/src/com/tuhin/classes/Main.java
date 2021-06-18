package com.tuhin.classes;

public class Main {
    public static void main(String[] args) {
        Phone iphone = new Phone("iPhone 11", 8, 8, 10);
        iphone.name = "iPhone 11";
        iphone.setCamera(45);
        iphone.setMemoryRam(6);
        iphone.setScreenSize(5);

        iphone.playMusic("All my friends are waiting for your call...");
        iphone.playMusic("Our wings are burning!");

        Phone samsung = new Phone("Samsung J7",2);
    }

}
