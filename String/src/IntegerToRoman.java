public class IntegerToRoman {
    public static void main(String[] args) {
        int input = 1994;
        String expected = "MCMXCIV";
        String actual = intToRoman(input);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static String intToRoman(int num) {
        int[] numEdge = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strEdge = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numEdge.length; i++) {
            int value = numEdge[i];
            String character = strEdge[i];
            while (num >= value) {
                num -= value;
                stringBuilder.append(character);
            }
            if (num == 0) {
                break;
            }
        }
        return new String(stringBuilder);
    }
}
