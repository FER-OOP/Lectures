package hr.fer.oop.topic16.example8;

public class EnglishConvert {
    // This snippet may be used freely, as long as the authorship note remains in the source code.
    private static final String[] lowNames = {
        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    private static final String[] tensNames = {
        "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    private static final String[] bigNames = {
        "thousand", "million", "billion"};

    /**
     * Converts an integer number into words (american english).
     *
     * @author Christian d'Heureuse, Inventec Informatik AG, Switzerland,
     * www.source-code.biz
*
     */
    public static String numberToWords(int n) {
        if (n < 0) {
            return "minus " + numberToWords(-n);
        }
        if (n <= 999) {
            return convert999(n);
        }
        String s = null;
        int t = 0;
        while (n > 0) {
            if (n % 1000 != 0) {
                String s2 = convert999(n % 1000);
                if (t > 0) {
                    s2 = s2 + " " + bigNames[t - 1];
                }
                if (s == null) {
                    s = s2;
                } else {
                    s = s2 + ", " + s;
                }
            }
            n /= 1000;
            t++;
        }
        return s;
    }

// Range 0 to 999.
    private static String convert999(int n) {
        String s1 = lowNames[n / 100] + " hundred";
        String s2 = convert99(n % 100);
        if (n <= 99) {
            return s2;
        } else if (n % 100 == 0) {
            return s1;
        } else {
            return s1 + " " + s2;
        }
    }

// Range 0 to 99.
    private static String convert99(int n) {
        if (n < 20) {
            return lowNames[n];
        }
        String s = tensNames[n / 10 - 2];
        if (n % 10 == 0) {
            return s;
        }
        return s + "-" + lowNames[n % 10];
    }
}
