package com.example.notasTeste;
import android.text.InputFilter;
import android.text.Spanned;

/**
 * original Criado por npatel em 4/5/2016.
 * adaptações por mim em 16/5/2020
 * https://capdroidandroid.wordpress.com/2016/04/07/set-minimum-maximum-value-in-edittext-android/.
 */
public class MinMaxFilter implements InputFilter {

    private int mIntMin, mIntMax;

    public MinMaxFilter(int minValue, int maxValue) {
        this.mIntMin = minValue;
        this.mIntMax = maxValue;
    }
    public MinMaxFilter(String minValue, String maxValue) {
        this.mIntMin = Integer.parseInt(minValue);
        this.mIntMax = Integer.parseInt(maxValue);
    }
    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            for (int i = dstart; i <= dend; i++){

            }
            StringBuilder inputText = new StringBuilder();
            inputText.append(dest, 0, dstart);
            inputText.append(source);
            inputText.append(dest, dend, dest.length());
            double input = Double.parseDouble(inputText.toString());
            if (isInRange(mIntMin, mIntMax, input))
            {   return null;}
        } catch (NumberFormatException ignored) { }
        return "";
    }

    private boolean isInRange(double a, double b, double c) {
        return b > a ? c >= a && c <= b : c >= b && c <= a;
    }
}