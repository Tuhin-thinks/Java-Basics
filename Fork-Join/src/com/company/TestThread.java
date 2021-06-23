package com.company;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println(nThreads);

        int[] numbers = new int[1000];

        for (int i=0; i<numbers.length; i++){
            numbers[i] = i;
        }

        ForkJoinPool forkJoinPool = new ForkJoinPool(nThreads);
        Long result = forkJoinPool.invoke(new Sum(numbers, 0, numbers.length));  // pass the array with 1000 elements
        System.out.println(result);
    }

    static class Sum extends RecursiveTask<Long>{
        int low, high, SEQUENTIAL_THRESHOLD = 1000;
        int [] array;

        public Sum(int[] array, int low, int high) {
            this.low = low;
            this.high = high;
            this.array = array;
        }

        public static void printResults(String name, long timeInNanos, double sum){
            System.out.printf(" %s completed in %8.3f milliseconds, with sum = %8.5f \n", name, timeInNanos / 1e6, sum);
        }

        @Override
        protected Long compute() {
            if ((high - low) <= SEQUENTIAL_THRESHOLD){
                long sum = 0;

                for (int i = low; i < high; ++i){
                    sum += array[i];
                }
                return sum;
            }
            else{
                int mid = low + (high - low) / 2;
                Sum left = new Sum(array, low, mid);
                Sum right = new Sum(array, mid, high);
                left.fork();
                long rightResult = right.compute();
                long leftResult = left.join();
                return leftResult + rightResult;
            }
        }
    }
}
