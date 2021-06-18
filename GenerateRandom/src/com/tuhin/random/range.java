package com.tuhin.random;

public class range {
    private int low=0;
    private int high=0;

    public range(int low, int high){
        this.low = low;
        this.high = high;
    }
    public boolean contains(int number){
        return (number >= low && number < high);
    }
}
