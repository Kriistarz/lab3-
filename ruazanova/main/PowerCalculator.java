package ru.ruazanova.main;

public class PowerCalculator {

    public static double powFromStrings(String xStr, String yStr) {
        int x = Integer.parseInt(xStr);
        int y = Integer.parseInt(yStr);

        return Math.pow(x, y);
    }

}
