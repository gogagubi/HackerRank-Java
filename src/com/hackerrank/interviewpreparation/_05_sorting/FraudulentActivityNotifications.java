package com.hackerrank.interviewpreparation._05_sorting;

public class FraudulentActivityNotifications {

    public static void main(String[] args) {
        if (true) {
            FraudulentActivityNotifications c = new FraudulentActivityNotifications();
            int[] expenditure = {2, 3, 4, 2, 3, 6, 8, 4, 5};
            int d = 5;

            System.out.println("Result " + c.activityNotifications(expenditure, d)); //Expected: 2
        }

        if (false) {
            FraudulentActivityNotifications c = new FraudulentActivityNotifications();
            int[] expenditure = {1, 2, 3, 4, 4};
            int d = 4;

            System.out.println("Result " + c.activityNotifications(expenditure, d)); //Expected: 0
        }

        if (false) {
            FraudulentActivityNotifications c = new FraudulentActivityNotifications();
            int[] expenditure = {10, 20, 30, 40, 50};
            int d = 3;

            System.out.println("Result " + c.activityNotifications(expenditure, d)); //Expected: 1
        }
    }


    private int activityNotifications(int[] expenditure, int d) {
        int notifications = 0;

        int[] counts = new int[201];
        for (int i = 0; i < d; i++) {
            counts[expenditure[i]]++;
        }

        for (int i = d; i < expenditure.length; i++) {
            double median = getMedian(d, counts);

            if (expenditure[i] >= 2 * median) {
                notifications++;

            }

            counts[expenditure[i]]++;
            counts[expenditure[i - d]]--;

        }

        return notifications;
    }

    private static double getMedian(int d, int[] counts) {
        double median = 0;
        if (d % 2 == 0) {
            Integer el1 = null;
            Integer el2 = null;
            int count = 0;
            for (int j = 0; j < counts.length; j++) {
                count += counts[j];
                if (el1 == null && count >= d/2) {
                    el1 = j;
                }
                if (el1 != null && count > d/2) {
                    el2 = j;
                    break;
                }
            }
            median = (el1 != null && el2 != null) ? (el1 + el2) / 2.0 : 0.0;
        } else {
            int count = 0;
            for (int j = 0; j < counts.length; j++) {
                count += counts[j];
                if (count > d/2) {
                    median = j;
                    break;
                }
            }
        }
        return median;
    }

}
