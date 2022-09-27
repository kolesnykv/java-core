package com.knubisoft.tasks.algorithm.fibonacci;

public class FibonacciImpl implements Fibonacci {
    @Override
    public int generateNFibonacciSequence(int n) {
        if(n<=0) {
            throw new IllegalArgumentException();
        }
        if(n<=1) {
            return n;
        }
        return  generateNFibonacciSequence(n-1) + generateNFibonacciSequence(n-2);
    }
}
