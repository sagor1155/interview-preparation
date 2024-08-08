package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        // reverse list
//        System.out.println("Reverse List");
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
//        reverse(list);
//        System.out.println(list);

        // max 'n' occurring words in descending order
        System.out.println(getMaxOccurringWords("abc bbc abc bbc aab bba cba abc", 3));

        // moving window average
//        int[] nums = {1, 2, 3, 4, 5, 6};
//        int windowSize = 3;
//        double[] result = movingWindow(nums, windowSize);
//        System.out.println(Arrays.toString(result));
    }

    public static double[] movingWindow(int[] nums, int windowSize) {
        double[] result = new double[nums.length];
        int[] arr = new int[windowSize];

        for (int i=0; i<nums.length; i++) {
            if ((i+1) <= windowSize) {
                arr[i] = nums[i];
                result[i] = findAverage(arr, (i+1));
            } else {
                shiftLeft(arr, nums[i]);
                result[i] = findAverage(arr, windowSize);
            }

//            for (int k=0; k<windowSize; k++) {
//                System.out.print(arr[k] + " ");
//            }
//            System.out.println();
        }
        return result;
    }

    public static double findAverage(int[] arr, int divider) {
        int sum = 0;
        for (int i=0; i<divider; i++) {
            sum += arr[i];
        }
        return (double) sum /divider;
    }

    public static void shiftLeft(int[] array, int newValue) {
        int n = array.length;

        // Shift elements to the left by one position
        for (int i = 0; i < n - 1; i++) {
            array[i] = array[i + 1];
        }

        // Add the new value at the end of the array
        array[n - 1] = newValue;

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

//        List<Map.Entry<String, Integer>> result = new ArrayList<>();
//        for (int i=0; i<n && !pq.isEmpty(); i++) {
//            result.add(pq.poll());
//        }
//        return result;

        // alternative
        return pq.stream()
                .sorted(pq.comparator())
                .limit(n)
                .toList();
    }
}