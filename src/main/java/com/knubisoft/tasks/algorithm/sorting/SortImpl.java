package com.knubisoft.tasks.algorithm.sorting;

import java.util.*;
import java.util.stream.Collectors;

public class SortImpl implements Sort {

    @Override
    public Map<Integer, List<Integer>> sortKeysAndValues(Map<Integer, List<Integer>> input) {
        return input.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

}
