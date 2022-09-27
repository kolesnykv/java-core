package com.knubisoft.tasks.algorithm.search;

public class SearchImpl implements Search{
    @Override
    public int binarySearch(long[] array, long v) {
        int start = 0;
        int end = array.length-1;
        while (end-start>1) {
            int mid = (end+start)/2;
            if(array[mid]==v) {
                return mid;
            }
            if(array[mid]<v) {
                start = mid+1;
            } else {
                end=mid;
            }
        }
        if(array[start]==v ) {
            return start;
        }
        if (array[end]==v) {
            return end;
        }
        return -1;
    }
}
