package com.hackerrank.problem_solving._11_recursion;

import java.util.*;

public class PasswordCracker {

    public static void main(String[] args) {
        if (true) {
            PasswordCracker o = new PasswordCracker();
            List<String> passwords = Arrays.asList("abra", "ka", "dabra");
            String loginAttempt = "abrakadabra";

            System.out.println(o.passwordCracker(passwords, loginAttempt));
        }

        if (true) {
            PasswordCracker o = new PasswordCracker();
            List<String> passwords = Arrays.asList("abra", "ka", "dabra");
            String loginAttempt = "kaabra";

            System.out.println(o.passwordCracker(passwords, loginAttempt));
        }

        if (true) {
            PasswordCracker o = new PasswordCracker();
            List<String> passwords = Arrays.asList("ab", "ba");
            String loginAttempt = "aba";

            System.out.println(o.passwordCracker(passwords, loginAttempt));
        }

        if (true) {
            PasswordCracker o = new PasswordCracker();
            List<String> passwords = Arrays.asList("because", "can", "do", "must", "we", "what");
            String loginAttempt = "wedowhatwemustbecausewecan";

            System.out.println(o.passwordCracker(passwords, loginAttempt));
        }

        if (true) {
            PasswordCracker o = new PasswordCracker();
            List<String> passwords = Arrays.asList("hello", "planet");
            String loginAttempt = "helloworld";

            System.out.println(o.passwordCracker(passwords, loginAttempt));
        }

        if (true) {
            PasswordCracker o = new PasswordCracker();
            List<String> passwords = Arrays.asList("ozkxyhkcst", "xvglh", "hpdnb", "zfzahm");
            String loginAttempt = "zfzahm";

            System.out.println(o.passwordCracker(passwords, loginAttempt));
        }

        if (true) {
            PasswordCracker o = new PasswordCracker();
            List<String> passwords = Arrays.asList("gurwgrb", "maqz", "holpkhqx", "aowypvopu");
            String loginAttempt = "gurwgrb";

            System.out.println(o.passwordCracker(passwords, loginAttempt));
        }

        //This test case runs out time without memoization
        if (true) {
            PasswordCracker o = new PasswordCracker();
            List<String> passwords = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
            String loginAttempt = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";

            System.out.println(o.passwordCracker(passwords, loginAttempt));
        }

        if (true) {
            PasswordCracker o = new PasswordCracker();
            List<String> passwords = Arrays.asList("ab", "abcd", "cd");
            String loginAttempt = "abcd";

            System.out.println(o.passwordCracker(passwords, loginAttempt));
        }

        if (true) {
            PasswordCracker o = new PasswordCracker();
            List<String> passwords = Arrays.asList("we", "web", "adaman", "barcod");
            String loginAttempt = "webarcodwebadamanweb";

            System.out.println(o.passwordCracker(passwords, loginAttempt));
        }
    }

    private String passwordCracker(List<String> passwords, String loginAttempt) {
        Deque<String> result = new LinkedList<>();
        crack(passwords, loginAttempt, result, new HashSet<>());

        if (result.isEmpty()) return "WRONG PASSWORD";

        StringBuilder ans = new StringBuilder();
        while (!result.isEmpty()) {
            ans.append(result.pollFirst());
            if (result.size() != 0) ans.append(" ");
        }

        return ans.toString();
    }

    private boolean crack(List<String> keys, String password, Deque<String> res, Set<String> memo) {
        if (password.length() == 0) return true;
        if (memo.contains(password)) return false;

        for (String key : keys) {
            if (password.startsWith(key)) {
                res.add(key);
                memo.add(password);

                if (crack(keys, password.substring(key.length()), res, memo)) {
                    return true;
                }

                res.removeLast();
            }
        }

        return false;
    }
}
