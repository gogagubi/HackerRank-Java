package com.hackerrank.interviewpreparation._03_dictionaries_and_hashmaps;


import java.util.*;

public class CountTriplets {

    public static void main(String[] args) {
        if (true) {
            CountTriplets c = new CountTriplets();
            List<Long> arr = Arrays.asList(1L, 4L, 16L, 64L);
            long r = 4;

            System.out.println("Result " + c.countTriplets(arr, r)); //Expected: 2
        }

        if (false) {
            CountTriplets c = new CountTriplets();
            List<Long> arr = Arrays.asList(1L, 2L, 2L, 4L);
            long r = 2;

            System.out.println("Result " + c.countTriplets(arr, r)); //Expected: 2
        }

        if (true) {
            CountTriplets c = new CountTriplets();
            List<Long> arr = Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L);
            long r = 3;

            System.out.println("Result " + c.countTriplets(arr, r)); //Expected: 6
        }

        if (false) {
            CountTriplets c = new CountTriplets();
            List<Long> arr = Arrays.asList(1L, 5L, 5L, 25L, 125L);
            long r = 5;

            System.out.println("Result " + c.countTriplets(arr, r)); //Expected: 4
        }

        if (true) {
            CountTriplets c = new CountTriplets();
            List<Long> arr = Arrays.asList(1L, 1L, 1L, 1L);
            long r = 1;

            System.out.println("Result " + c.countTriplets(arr, r)); //Expected: 4
        }

    }

    public long countTriplets(List<Long> arr, long r) {
        long count = 0;
        Map<Long, Long> leftMap = new HashMap<>();
        Map<Long, Long> rightMap = new HashMap<>();

        for(int i = 0; i < arr.size(); i ++){
            long curr = arr.get(i);
            rightMap.put(curr, rightMap.getOrDefault(curr, 0L) + 1);
        }

        for(int i = 0; i < arr.size(); i ++){
            long current = arr.get(i);
            rightMap.put(current, rightMap.get(current) - 1);

            Long left = leftMap.get(current / r);
            Long right = rightMap.get(current * r);

            if(current % r == 0 && left != null && right != null){
                count += left * right;
            }

            leftMap.put(current, leftMap.getOrDefault(current, 0L) + 1);

        }

        return count;
    }

}
