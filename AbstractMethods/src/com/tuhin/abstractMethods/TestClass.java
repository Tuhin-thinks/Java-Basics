package com.tuhin.abstractMethods;

public class TestClass extends TestAbstractClass{  // abstract classes require to use extends
    // cannot extend multiple abstract class, does not support multiple inheritance

    @Override
    public void printName(String name) {
        System.out.println(name);
    }
}
