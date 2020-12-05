package com.hackerrank.interviewpreparation._01_warmup;

import java.util.HashMap;
import java.util.Map;

public class SalesByMatch {

    public static void main(String[] args) {
        if (true) {
            SalesByMatch s = new SalesByMatch();
            int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};

            System.out.println("Result = " + s.sockMerchant(ar.length, ar));
        }

    }

    private int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> counts = new HashMap<>();
        for(int i = 0; i < n; i ++){
            counts.put(ar[i], counts.getOrDefault(ar[i], 0) + 1);
        }

        int result = 0;
        for(int key: counts.keySet()){
            result += counts.get(key) / 2;
        }

        return result;
    }

}
