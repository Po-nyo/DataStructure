package week_5.p2;

public class TypeConversion {

    public static int String2Int(String input) {
        int result = 0;

        for(int i=0; i<input.length(); i++) {
            int currentValue = input.charAt(input.length()-1-i) - '0';
            result += currentValue * Math.pow(10, i);
        }

        return result;
    }

    public static double String2Double(String input) {
        double result = 0;

        int dot = 0;

        for(int i=0; i<input.length(); i++) {
            if(input.charAt(input.length()-1-i) == '.') {
                dot = i;
                break;
            }
        }

        result = String2Int(input.replaceAll("\\.", "")) / Math.pow(10, dot);

        return result;
    }
}
