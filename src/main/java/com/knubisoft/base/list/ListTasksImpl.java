package com.knubisoft.base.list;

import com.sun.jdi.LongValue;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListTasksImpl implements ListTasks {
    @Override
    public List<String> addElements(String... elements) {
        return new ArrayList<>(List.of(elements));
    }

    @Override
    public List<String> getElementsByIndexes(List<String> elements, int[] indexes) {
        if(indexes==null)
            throw new IllegalArgumentException();
            for (int index : indexes) {
                if (index > 10 || index < 0)
                    throw new IllegalArgumentException();

            }
        for (int i: indexes) {
            elements.add(elements.get(i));
        }
        return elements;
    }

    @Override
    public ArrayList<String> addElementsByIndexes(ArrayList<String> elements, int[] indexes) {
        if(indexes==null)
            throw new IllegalArgumentException();
        for (int index : indexes) {
            if (index > 10 || index < 0)
                throw new IllegalArgumentException();

        }
        for (int i: indexes) {
            elements.add(i,elements.get(i));
        }
        return elements;
    }

    @Override
    public LinkedList<String> setElementsByIndexes(LinkedList<String> elements, int[] indexes) {
        if(indexes==null)
            throw new IllegalArgumentException();
        for (int index : indexes) {
            if (index > 10 || index < 0)
                throw new IllegalArgumentException();

        }
        for (int i: indexes) {
            elements.set(i,elements.get(i));
        }
        return elements;
    }

    @Override
    public int getListSize(List<String> list) {
        return list == null ? 0 : list.size();
    }

    @Override
    public List<Long> merge(List<Integer> first, List<Long> second, List<String> third) {
        List<Long> list = new ArrayList<>();
        list.addAll(first.stream()
                .map(x -> Long.valueOf(x))
                .toList());
        list.addAll(second.stream()
                .toList());
        list.addAll(third.stream()
                .map(x -> Long.valueOf(x))
                .toList());
        return list;

    }

    @Override
    public int findMaxValue(List<Integer> first, List<Integer> second, List<Integer> third) {
        return Math.max(Math.max(Collections.max(first),Collections.max(second))
                ,Collections.max(third));
        }

    @Override
    public int findMinValue(List<Integer> first, List<Integer> second, List<Integer> third) {
        return Math.min(Math.max(Collections.min(first),Collections.min(second))
                ,Collections.min(third));
    }

    @Override
    public int multiplyMax2Elements(List<Integer> first, List<Integer> second, List<Integer> third) {
        return -1;
    }

    @Override
    public List<String> removeNulls(List<String> list) {
        return list.stream()
                .filter(x -> x!=null)
                .toList();
    }

    @Override
    public List<Integer> flatMapWithoutNulls(List<List<Integer>> list) {
        if (list == null) throw new NoSuchElementException();
        List<Integer> integers = new ArrayList<>();
        for(List l: list) {
            integers.addAll(l.stream()
                    .filter(x -> x!=null)
                    .toList());
        }
        return integers;
    }

    @Override
    public List<Integer> cloneIds(List<Integer> originalIds) {
        if (originalIds == null) throw new NoSuchElementException();
        return originalIds.stream()
                .filter(x -> x!=null)
                .toList();
    }

    @Override
    public List<String> shuffle(List<String> originalStrings) {
        Collections.shuffle(originalStrings);
        return originalStrings;
    }

    @Override
    public String getLastElement(LinkedList<String> list) {
        if(list == null)
            throw new NoSuchElementException();
        if (list.isEmpty())
            return "";
        return list.getLast();
    }

    @Override
    public List<String> compareElements(LinkedList<String> originalCollection, LinkedList<String> additionalCollection) {
        if(originalCollection==null || additionalCollection==null)
            throw new IllegalArgumentException();
        return originalCollection.stream()
                .filter(additionalCollection::contains)
                .collect(Collectors.toList());
    }
}
