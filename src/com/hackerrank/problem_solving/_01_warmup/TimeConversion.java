package com.hackerrank.problem_solving._01_warmup;

public class TimeConversion {

    public static void main(String[] args) {
        if (false) {
            TimeConversion c = new TimeConversion();
            String s = "12:01:00PM";

            System.out.println("Result " + c.timeConversion(s));
        }

        if (true) {
            TimeConversion c = new TimeConversion();
            String s = "11:59:59PM";

            System.out.println("Result " + c.timeConversion(s));
        }


    }

    private String timeConversion(String s) {
        int hour = Integer.valueOf(s.substring(0, 2));
        String suff = s.substring(s.length() - 2);

        if (suff.equals("AM") && hour == 12) {
            hour = 0;
        } else if (suff.equals("PM") && hour != 12) {
            hour += 12;
        }

        String hourStr = hour > 9 ? String.valueOf(hour) : "0" + hour;
        return hourStr + s.substring(2, s.length() - 2);
    }

}
