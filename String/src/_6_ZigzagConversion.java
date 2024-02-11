public class _6_ZigzagConversion {
    public static void main(String[] args) {
        String inputStr = "PAYPALISHIRING";
        int inputNum = 3;
        String expected = "PAHNAPLSIIGYIR";
        String actual = convert(inputStr, inputNum);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int length = s.length();
        int[] flag = new int[length];
        flag[0] = 1;
        int direction = 1;
        for (int i = 1; i < length; i++) {
            if (flag[i - 1] == numRows) {
                direction = -1;
            } else if (flag[i - 1] == 1) {
                direction = 1;
            }
            flag[i] = flag[i - 1] + direction;
        }
        int row = 1;
        int index = 0;
        char[] charArr = new char[length];
        while (row <= numRows) {
            for (int i = 0; i < length; i++) {
                if (flag[i] == row) {
                    charArr[index++] = s.charAt(i);
                }
            }
            row++;
        }
        return new String(charArr);
    }
}
