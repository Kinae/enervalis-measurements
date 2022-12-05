package abb.interview.display;

import java.text.DecimalFormat;

public class PowerFormatter {

    private static final DecimalFormat decimalFormat = new DecimalFormat("#.0000"); // RoundingMode is missing

    private PowerFormatter() {
    }

    public static String format(double value) {
        return decimalFormat.format(value);
    }

}
