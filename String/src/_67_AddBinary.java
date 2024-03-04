public class _67_AddBinary { // 参考415题
    public static void main(String[] args) {
        String a = "1010", b = "1011";
        String expected = "10101";
        String actual = addBinary(a, b);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int digit_a = i >= 0 ? a.charAt(i) - '0' : 0;
            int digit_b = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = digit_a + digit_b + carry;
            carry = sum / 2;
            result.append(sum % 2);
            i--;
            j--;
        }
        if (carry != 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}
