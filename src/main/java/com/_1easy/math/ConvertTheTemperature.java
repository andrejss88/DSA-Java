package com._1easy.math;

/**
 * 2469
 * Convert Celsius into Kelvin and Fahrenheit
 * and return it as an array ans = [kelvin, fahrenheit]
 * <p>
 * Note that:
 * Kelvin = Celsius + 273.15
 * Fahrenheit = Celsius * 1.80 + 32.00
 * <p>
 * Example:
 * Input: celsius = 36.50
 * Output: [309.65000,97.70000]
 */
public class ConvertTheTemperature {

    public static double[] convertTemperature(double celsius) {
        double kelvin = celsius + 273.15;
        double fahrenheit = celsius * 1.8 + 32;

        return new double[]{kelvin, fahrenheit};
    }
}
