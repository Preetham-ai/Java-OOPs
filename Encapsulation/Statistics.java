package com.math.advanced;

public class Statistics {
    public static double calculateMean(double[] values) {
        double sum = 0;
        for(double v : values) sum += v;
        return sum / values.length;
    }
    
    public static double calculateStandardDeviation(double[] values) {
        double mean = calculateMean(values);
        double sum = 0;
        for(double v : values) {
            sum += Math.pow(v - mean, 2);
        }
        return Math.sqrt(sum / values.length);
    }

    public static void main(String[] args) {
        double[] data = {12.5, 18.3, 11.2, 19.0, 22.1, 14.7};
        System.out.printf("Mean: %.2f%n", calculateMean(data));
        System.out.printf("Standard Deviation: %.2f%n", calculateStandardDeviation(data));
    }
}
