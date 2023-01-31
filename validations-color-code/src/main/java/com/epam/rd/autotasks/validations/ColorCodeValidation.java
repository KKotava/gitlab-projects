package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorCodeValidation {
    public static boolean validateColorCode(String color) {

        if (color == null || color.isEmpty()) {
            return false;
        }
        Pattern pattern1 = Pattern.compile("#([A-F\\d]){3}", Pattern.CASE_INSENSITIVE);
        Matcher matcher1 = pattern1.matcher(color);
        Pattern pattern2 = Pattern.compile("#([A-F\\d]){6}", Pattern.CASE_INSENSITIVE);
        Matcher matcher2 = pattern2.matcher(color);
        if (matcher1.matches() || matcher2.matches()) {
            return true;
        } else {
            return false;
        }
    }
}





