package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Factorial {
    private final List<Integer> memoize_cache = new ArrayList<>();

    public Integer calculate(Integer input){
        if (input == 0){
            return 1;
        }
        else{
            if (memoize_cache.size() >= input){  // if input == 4, we check if size >= 4
                System.out.printf("\tFetching %d from cache.",input);
                return memoize_cache.get(input-1);  // return the result for index 3 (4th value)
            }
            int factorial = input * calculate(input-1);
            memoize_cache.add(factorial);
//            System.out.println("Cache: "+ Arrays.toString(memoize_cache.toArray()));
            return factorial;
        }
    }
}
