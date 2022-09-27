package com.knubisoft.tasks.algorithm.charsinstring;

import java.util.*;
import java.util.stream.Collectors;

public class CharsInStringImpl implements CharsInString {
    @Override
    public Map<Character, Integer> charactersCount(String text) {
        if(text == null) {
            throw new IllegalArgumentException();
        }
        Set<Character> set = Arrays
                .stream(text.replaceAll(" ", "").chars().toArray())
                .mapToObj(s -> (char) s)
                .collect(Collectors.toSet());
        Map<Character, Integer> charCount = new HashMap<>();
        for (Character ch : set) {
            int freq = Collections.frequency(text.chars().mapToObj(c -> (char) c).collect(Collectors.toList()), ch);
            charCount.put(ch, freq);
        }
        return charCount;
    }
}
