package BinarySearch;

//https://leetcode.com/problems/minimum-speed-to-arrive-on-time/


import java.text.DecimalFormat;

public class MinimumSpeedtoArriveonTime1870 {
    static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
//        int[] dist = {1, 3, 2};
//        double hour = 6;
//        System.out.println(minSpeedOnTime(dist, hour));
//
//        int[] dist1 = {1, 3, 2};
//        double hour1 = 2.7;
//        System.out.println(minSpeedOnTime(dist1, hour1));
//
//        int[] dist2 = {1, 3, 2};
//        double hour2 = 1.9;
//        System.out.println(minSpeedOnTime(dist2, hour2));
//

        int[] dist3 = {1, 1, 100000};
        double hour3 = 2.01;
        System.out.println(minSpeedOnTime(dist3, hour3));
    }

    static public int minSpeedOnTime(int[] dist, double hour) {

        if (hour < dist.length - 1) {
            return -1;
        }
        int sum = 0;
        for (int d : dist) {
            sum += d;
        }
        return (int) binarySearch(dist, 1, sum, hour);
    }

    static private double binarySearch(int[] dist, double st, double end, double hour) {

        if (st > end) {
            return -1;
        }

        double mid = Double.valueOf(df.format(st + (end - st) / 2));

        if (hour == mid) {
            return calculateSpeed(dist, mid);
        }
        if (hour < mid) {
            return binarySearch(dist, Double.valueOf(df.format(st)), Double.valueOf(df.format(mid - .01)), hour);
        }
        return binarySearch(dist, mid, Double.valueOf(df.format(end)), hour);
    }

    static double calculateSpeed(int[] dist, double time) {

        double sum = 0;
        for (int d : dist) {
            sum += (double) d / time;
        }
        return Math.ceil(sum);
    }
}