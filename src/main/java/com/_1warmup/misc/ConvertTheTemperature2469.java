package com._1warmup.misc;

import java.util.Arrays;

public class ConvertTheTemperature2469 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(convertTemperature(36.5)));
    }

    public static double[] convertTemperature(double celsius) {
        double kelvin = celsius + 273.15;
        double fahrenheit = celsius * 1.8 + 32;

        return new double[]{kelvin, fahrenheit};
    }
}
