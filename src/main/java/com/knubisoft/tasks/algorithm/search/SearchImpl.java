package com.knubisoft.tasks.algorithm.search;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class SearchImpl implements Search {
    @Override
    public int binarySearch(long[] array, long searchKey) {
        if(!isSorted(array)) {
            throw new IllegalArgumentException("Inputted array is not sorted");
        }
        int lowerBound = 0;
        int upperBound = array.length - 1;
        int currentIndex;
        while (true) {
            currentIndex = (lowerBound + upperBound) / 2;
            if (array[currentIndex] == searchKey) {
                return currentIndex;
            } else if (lowerBound > upperBound) {
                return -1;
            } else {
                if (array[currentIndex] < searchKey) {
                    lowerBound = currentIndex + 1;
                } else {
                    upperBound = currentIndex - 1;
                }
            }
        }
    }
    public static boolean isSorted(long[] array) {
        return IntStream.range(0, array.length - 1).noneMatch(i -> array[i] > array[i + 1]);
    }
}
