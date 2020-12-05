package com.hackerrank.problem_solving._02_warmup;

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
        String prefix = s.substring(0, 2);
        String middle = s.substring(2, s.length() - 2);
        String suffix = s.substring(s.length() - 2, s.length());
        int hours = Integer.valueOf(prefix);

        if(suffix.equals("AM")){
            if(prefix.equals("12")){
                prefix = "00";
            }
        }
        else{
            if(hours < 12){
                prefix = Integer.toString(hours + 12);
            }
        }

        return prefix + middle;
    }

}
