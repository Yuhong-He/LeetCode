public class StringToIntegerAtoi {
    public static void main(String[] args) {
        String input = "2147483648";
        int expected = 2147483647;
        int actual = myAtoi(input);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static int myAtoi(String s) {
        String newStr = s.trim();
        int length = newStr.length();
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (index < length) {
            if (index == 0 && (newStr.charAt(0) == '-' || newStr.charAt(0) == '+')) {
                stringBuilder.append(newStr.charAt(0));
            } else if (!Character.isDigit(newStr.charAt(index))) {
                break;
            } else if (Character.isDigit(newStr.charAt(index))) {
                stringBuilder.append(newStr.charAt(index));
            }
            index ++;
        }
        String numStr = new String(stringBuilder);
        if (numStr.isEmpty() || numStr.equals("+") || numStr.equals("-")) {
            return 0;
        }
        try {
            return Integer.parseInt(numStr);
        } catch (Exception e) {
            int result = 0;
            boolean isNegative = numStr.charAt(0) == '-';
            int limit = isNegative ? Integer.MIN_VALUE : -Integer.MAX_VALUE;
            int multmin = limit / 10;
            for (int i = isNegative ? 1 : 0; i < numStr.length(); i++) {
                int digit = numStr.charAt(i) - '0'; // 减去0的ASCII码值，将字符转换为对应的数字值
                if (result < multmin) {
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result *= 10;
                if (result < limit + digit) {
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result -= digit;
                System.out.println(result);
                System.out.println(digit);
            }
            return isNegative ? result : -result;
        }
    }
}
