package com.hackerrank.interviewpreparation._03_dictionaries_and_hashmaps;

import java.util.*;

public class FrequencyQueries {

    public static void main(String[] args) {
        if (true) {
            FrequencyQueries c = new FrequencyQueries();
            List<List<Integer>> queries = Arrays.asList(
                    Arrays.asList(1, 5),
                    Arrays.asList(1, 6),
                    Arrays.asList(3, 2),
                    Arrays.asList(1, 10),
                    Arrays.asList(1, 10),
                    Arrays.asList(1, 6),
                    Arrays.asList(2, 5),
                    Arrays.asList(3, 2)
            );

            System.out.println("Result " + c.freqQuery(queries));
        }


        if (false) {
            FrequencyQueries c = new FrequencyQueries();
            List<List<Integer>> queries = Arrays.asList(
                    Arrays.asList(1, 3),
                    Arrays.asList(2, 3),
                    Arrays.asList(3, 2),
                    Arrays.asList(1, 4),
                    Arrays.asList(1, 5),
                    Arrays.asList(1, 5),
                    Arrays.asList(1, 4),
                    Arrays.asList(3, 2),
                    Arrays.asList(2, 4),
                    Arrays.asList(3, 2)
            );

            System.out.println("Result " + c.freqQuery(queries));
        }


    }

    public List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> counts = new HashMap<>();

        for (int i = 0; i < queries.size(); i++) {
            List<Integer> curr = queries.get(i);
            int op = curr.get(0);
            int data = curr.get(1);

            if (op == 1) {
                int occurrences = map.getOrDefault(data, 0);
                counts.put(occurrences, counts.getOrDefault(occurrences, 0) - 1);
                map.put(data, ++occurrences);
                counts.put(occurrences, counts.getOrDefault(occurrences, 0) + 1);
            } else if (op == 2) {
                if (map.containsKey(data) && map.get(data) > 0) {
                    int occurrences = map.getOrDefault(data, 0);
                    counts.put(occurrences, counts.getOrDefault(occurrences, 0) - 1);
                    map.put(data, --occurrences);
                    counts.put(occurrences, counts.getOrDefault(occurrences, 0) + 1);
                }
            } else {
                int count = counts.getOrDefault(data, 0);
                if(count > 0) list.add(1);
                else list.add(0);
            }

        }

        return list;
    }

}
