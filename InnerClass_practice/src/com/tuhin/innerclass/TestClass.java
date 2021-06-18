package com.tuhin.innerclass;

public class TestClass {
    private int agr;
    private String name;

    private class TestInnerClass{
        private String name;
        public TestInnerClass(String name){
            this.name = name;
        }
        private void printAge(){
            System.out.println("Age:" + agr);
        }
    }
}
