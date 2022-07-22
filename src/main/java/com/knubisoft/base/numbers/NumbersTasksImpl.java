package com.knubisoft.base.numbers;

import java.math.BigInteger;

public class NumbersTasksImpl implements NumbersTasks {

    @Override
    public void swapTwoNumbersWithoutUsingTemporaryVariable(int firstNumber, int secondNumber) {
        int temp = firstNumber;
        firstNumber = secondNumber;
        secondNumber = temp;
    }

    @Override
    public boolean isUglyInt(int number) {
        if (number < 1) return false;
        int temp;
        do {
            temp = number;
            if (number % 2 == 0) number /= 2;
            if (number % 3 == 0) number /= 3;
            if (number % 5 == 0) number /= 5;
        } while (temp != number);
        return number == 1;
    }

    @Override
    public int addDigits(int number) {
        int sum;
        do{
            sum=0;
            while (number>0){
                sum+=number%10;
                number/=10;
            }
            number=sum;
        }while(sum>9);
        return sum;
    }

    @Override
    public boolean isHarshadNumber(int number) {
        int sum = 0, temp;
        if(number==0)
            return false;
        else temp = number;
        while (number>0){
            sum+=number%10;
            number/=10;
        }
        return temp%sum==0;
    }

    @Override
    public boolean isPrime(int number) {
        for (int i = 2; i<Math.sqrt(number); i++) {
            if (number%i==0) return false;
        }
        return true;
    }

    @Override
    public boolean isArmstrongNumber(int number) {
        int sum = 0, temp = number, n=number,digits=0;
        while (n>0) {
            digits ++ ;
            n /= 10;
        }
        while (number>0) {
            sum += Math.pow(number % 10, digits);
            number /= 10;
        }
        return sum==temp;
    }

    @Override
    public BigInteger factorial(int number) {
        BigInteger num = BigInteger.valueOf(1);
        for(int i=1; i<=number; i++){
            num = num.multiply(BigInteger.valueOf(i));
        }
        return num;
    }

    @Override
    public boolean palindrome(int number) {
        int temp=number, sum=0;
        while(number>0){
            sum=(sum*10)+number%10;
            number=number/10;
        }
        return temp==sum;
    }

    @Override
    public boolean isAutomorphic(int number) {
        return false;
    }
}
