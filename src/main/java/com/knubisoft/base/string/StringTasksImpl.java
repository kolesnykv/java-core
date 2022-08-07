package com.knubisoft.base.string;

import java.util.*;
import java.util.stream.Collectors;


public class StringTasksImpl implements StringTasks {

    @Override
    public String reverseString(String original) {
        if (original==null) throw new IllegalArgumentException();
        return new StringBuilder(original).reverse().toString();
    }

    @Override
    public String insertStringInMiddle(String original, String toInsert) {
        if (original==null || toInsert==null
                || original.length()==0 || toInsert.length()==0)
            throw new IllegalArgumentException();
        return original
                .substring(0,(int)Math.floor(original.length()/2)) + toInsert+original
                .substring(original.length()/2);
    }

    @Override
    public String insertSymbolInString(String original, char toInsert, int position) {
        if (original==null || position < 0
                || position>original.length() || original.length()==0 )
            throw new IllegalArgumentException();
        return original.substring(0,position)+ toInsert + original.substring(position);
    }

    @Override
    public String appendToString(StringBuilder original, String toAppend) {
        if (original==null || toAppend == null || original.isEmpty()) throw new NoSuchElementException();
        return original.append(toAppend).toString();
    }

    @Override
    public boolean isPalindrome(String palindrome) {
        if (palindrome==null) throw new RuntimeException();
        return palindrome.equals(new StringBuilder(palindrome).reverse().toString());
    }

    @Override
    public boolean hasLowerCase(String str) {
        if (str==null)
            throw new IllegalArgumentException();
        for (char i: str.toCharArray()) {
            if (Character.isUpperCase(i))
                return false;
        }
        return true;
    }

    @Override
    public String uniqueCharacters(String str) {
        if (str==null)
            throw new IllegalArgumentException();
        ArrayList<String> list =new ArrayList<>(Arrays.asList(str.split("")));
        String result ="";
        for (String s: list) {
            if((Collections.frequency(list,s.toLowerCase())
                    +Collections.frequency(list,s.toUpperCase()))==1) result+=s;
        }
        return result;
    }

    @Override
    public String removeAllCharacters(String str, char charToRemove) {
        if (str == null)
            throw new IllegalArgumentException();
        return str.replaceAll(String.valueOf(charToRemove),"");
    }

    @Override
    public String toCamelCase(String str) {
        if (str == null || str.length()==0)
            throw new IllegalArgumentException();
        String[] arr = str.split("[-|_| ]");
        return arr[0] + Arrays.stream(arr)
                .skip(1)
                .map(o -> Character.toUpperCase(o.charAt(0))+o.substring(1))
                .collect(Collectors.joining());
    }

    @Override
    public String getCountRepeatableString(String str) {
        if (str==null) throw new IllegalArgumentException();
        int counter = 1;
        char[] arr = str.toCharArray();
        String out= "";
        for (int i=0; i<arr.length; i++) {
            out+=counter;
            for (int j=i+1; j<arr.length; j++)
            {
                if(arr[i]==arr[j]) {
                    counter++;
                    if(counter>9) counter=1;
                    out+=counter;
                }
            }
            counter=1;
        }
        return out;
    }

    @Override
    public String sortStringCharactersAsc(String str) {
        if (str==null) throw new IllegalArgumentException();
        return Arrays.stream(str.split(""))
                .sorted()
                .collect(Collectors.joining());
    }
}
