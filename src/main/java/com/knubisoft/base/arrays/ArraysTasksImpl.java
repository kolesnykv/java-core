package com.knubisoft.base.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class ArraysTasksImpl implements ArraysTasks {

    @Override
    public int[] reverse(int[] array) {
        int[] reverse = new int[array.length];
        int j = array.length;
        for (int i = 0; i < array.length; i++) {
            reverse[j - 1] = array[i];
            j = j - 1;
        }
        return reverse;
    }

    @Override
    public int[] mergeArrays(int[] array1, int[] array2) {
        int[] merge = new int[array1.length+array2.length];
        int i = 0;
        for (int o1: array1) {
            merge[i] = o1;
            i++;
        }
        for (int o2: array2) {
            merge[i] = o2;
            i++;
        }
        return merge;
    }

    @Override
    public int[] findMax3InArray(int[] array) {
        int biggest=0;
        int[] max;
        int index=0;
        if(array.length>2){
            max = new int[3];
            for(int i = 0; i < 3; i++) {
                for (int j=0; j<array.length; j++) {
                    if (array[j]>biggest) {
                        biggest = array[j];
                        index = j;
                    }
                }
                max[i] = biggest;
                array[index] = 0;
                biggest = 0;
            }
        }
        else {
            max = new int[array.length];
            for (int i=0; i<array.length; i++) {
                max[i]= array[i];
            }
        }
        return max;
    }

    @Override
    public int findLongestIncreasingContinuesSubsequence(int[] array) {
        int counter = 1;
        int longest = 1;
        if (array.length==0) return 0;
        for (int i=0; i<array.length-1; i++) {
            if (array[i]<array[i+1]) {
                counter++;
                longest = counter;
            }
            else counter = 1;
        }
        return longest;
    }

    @Override
    public int sumOfAllUniqueElements(int[] array) {
        return Arrays.stream(array).distinct().sum();
    }

    @Override
    public int[] moveZeroes(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i]==0) {
                for (int j = i+1; j< array.length; j++) {
                    if(array[j]!=0) {
                        array[i] = array[j];
                        array[j] = 0;
                        break;
                    }
                }
            }
        }
        return array;
    }

    @Override
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        for (int i: nums) {
            if (i==original) original*=2;
        }
        return original;
    }

    @Override
    public String longestCommonPrefix(String[] words) {
        if (words.length == 0)
            return "";
        if (words.length == 1)
            return words[0];
        Arrays.sort(words);
        int end = Math.min(words[0].length(), words[words.length-1].length());
        int i = 0;
        while (i < end && (words[0].charAt(i) == words[words.length-1].charAt(i)) )
            i++;
        return words[0].substring(0, i);
    }

    @Override
    public int missingNumber(int[] array) {
        int greates = array.length;
        boolean flag = false;
        for (int i=0; i<=greates; i++){
            flag = false;
            for (int num: array) {
                if (num == i) {
                    flag = true;
                    break;
                }
            }
            if (!flag) return i;
        }
    return -1;
    }

    @Override
    public boolean containsDuplicate(int[] array) {
        return array.length != Arrays.stream(array).distinct().count();
    }
}
