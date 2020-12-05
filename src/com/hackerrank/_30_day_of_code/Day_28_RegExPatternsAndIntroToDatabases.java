package com.hackerrank._30_day_of_code;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day_28_RegExPatternsAndIntroToDatabases {

    public static void main(String[] args) {
        if (true) {
            Day_28_RegExPatternsAndIntroToDatabases s = new Day_28_RegExPatternsAndIntroToDatabases();
            List<String> names = Arrays.asList("riya", "julia", "julia", "julia", "samantha", "tanya");
            List<String> emails = Arrays.asList("riya@gmail.com", "julia@julia.me", "sjulia@gmail.com", "julia@gmail.com", "samantha@gmail.com", "tanya@gmail.com");

            System.out.println("Result");
            s.printNames(names, emails);
            System.out.println();
        }
    }

    private void printNames(List<String> firstNames, List<String> emails) {
        String emailRegEx = ".+@gmail\\.com$";
        Pattern pattern = Pattern.compile(emailRegEx);
        Queue<String> queue = new PriorityQueue<>();

        for (int i = 0; i < emails.size(); i++) {
            Matcher matcher = pattern.matcher(emails.get(i));
            if (matcher.find()) {
                queue.add(firstNames.get(i));
            }
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

}
