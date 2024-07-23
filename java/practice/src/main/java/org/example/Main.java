package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Reverse List");
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
//        reverse(list);
//        System.out.println(list);

        System.out.println(getMaxOccurringWords("abc bbc abc bbc aab bba cba abc", 3));
    }

    public static void reverse(List<Integer> list) {
        int left = 0;
        int right = list.size()-1;

        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static List<Map.Entry<String, Integer>> getMaxOccurringWords(String input, Integer n) {
        String[] words = input.split("\\s+");
        Map<String, Integer> map = new HashMap<>();

        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue().compareTo(a.getValue())
        );

        pq.addAll(map.entrySet());

        List<Map.Entry<String, Integer>> result = new ArrayList<>();

        for (int i=0; i<n && !pq.isEmpty(); i++) {
            result.add(pq.poll());
        }

        return result;
    }
}