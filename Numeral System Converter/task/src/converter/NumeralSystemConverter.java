package converter;

public class NumeralSystemConverter {
    public static String convertNumber(int sourceRadix, String sourceNumber, int targetRadix) {

        if (!correctSourceNumber(sourceRadix, sourceNumber)) {
            return "";
        }
        int index = sourceNumber.indexOf(".");
        String integerPart = sourceNumber;
        String fractionalPart = "";
        if (index >= 0) {
            integerPart = sourceNumber.substring(0, index);
            fractionalPart = sourceNumber.substring(index + 1);
        }
        StringBuilder sb = new StringBuilder(convertIntegerPart(sourceRadix, integerPart, targetRadix));
        if (fractionalPart.length() > 0) {
            sb.append("." + convertFractionalPart(sourceRadix, fractionalPart, targetRadix));
        }
        return sb.toString();
    }

    private static boolean correctSourceNumber(int sourceRadix, String number) {

        int[] digits = parseStringInDigitArray(number);
        for (int digit : digits) {
            if (digit > sourceRadix) {
                System.out.println("Error: invalid literals in number with base " + sourceRadix);
                return false;
            }
        }
        return true;
    }

    private static String convertFractionalPart(int sourceRadix, String fractionalPart, int targetRadix) {
        return convertFractionalPartIntoNewBase("0." + convertFractionalPartIntoDecimal(sourceRadix, fractionalPart), targetRadix);
    }

    private static String convertFractionalPartIntoDecimal(int sourceRadix, String fractionalPart) {

        if (sourceRadix == 10) {
            return parseLiteralsInDigits(fractionalPart);
        }
        int[] digits = parseStringInDigitArray(fractionalPart);
        double decimalValue = 0;
        for (int i = 0; i < digits.length; i++) {
            decimalValue += digits[i] / Math.pow(sourceRadix, i + 1);
        }
        return Double.toString(decimalValue).split("[.,]")[1].trim();
    }

    private static String parseLiteralsInDigits(String data) {

        char[] literals = data.toCharArray();
        StringBuilder digits = new StringBuilder();
        for (int i = 0; i < literals.length; i++) {
            if (Character.isDigit(literals[i])) {
                digits.append(literals[i]);
            } else {
                digits.append(10 + literals[i] - 'a');
            }
        }
        return digits.toString();
    }

    private static int[] parseStringInDigitArray(String data) {

        char[] literals = data.toCharArray();
        int[] digits = new int[literals.length];
        for (int i = 0; i < literals.length; i++) {
            if (Character.isDigit(literals[i])) {
                digits[i] = Character.digit(literals[i], 10);
            }
            else {
                digits[i] = 10 + literals[i] - 'a';
            }
        }
        return digits;
    }

    private static String convertFractionalPartIntoNewBase(String decimalValue, int newBase) {

        StringBuilder newBaseValue = new StringBuilder();
        int accuracy = 5;
        for (int i = 0; i < accuracy; i++) {
            double value = Double.parseDouble(decimalValue);
            int num = (int) (value * newBase);
            if (num > 9) {
                newBaseValue.append((char)('a' + num - 10));
            } else {
                newBaseValue.append(num);
            }
            decimalValue = Double.toString(value * newBase - num);
        }
        return newBaseValue.toString();
    }

    private static String convertIntegerPart(int sourceRadix, String integerPart, int targetRadix) {

        String result = "";
        long num = 0;
        if (sourceRadix == 1) {
            num = integerPart.length();
        } else {
            num = Long.parseLong(integerPart, sourceRadix);
        }

        if (targetRadix == 1) {
            for (int i = 0; i < num; i++) {
                result += 1;
            }
        } else {
            result = Long.toString(num, targetRadix);
        }
        return result;
    }
}
