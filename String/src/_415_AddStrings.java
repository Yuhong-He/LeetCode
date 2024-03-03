public class _415_AddStrings {
    public static void main(String[] args) {
        String num1 = "11", num2 = "123";
        String expected = "134";
        String actual = addStrings(num1, num2);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static String addStrings(String num1, String num2) { // 清理过的标准答案
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while(i >= 0 || j >= 0){
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--; j--;
        }
        if(carry == 1) res.append(1);
        return res.reverse().toString();
    }

    public static String addString2(String num1, String num2) { // 自己写的，和标准答案逻辑相同
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int temp = 0;
        while (i >= 0 || j >= 0) {
            int n1 = 0;
            if (i >= 0) {
                n1 = num1.charAt(i) - '0';
            }
            int n2 = 0;
            if (j >= 0) {
                n2 = num2.charAt(j) - '0';
            }
            int temp_result = n1 + n2 + temp;
            result.append(temp_result % 10);
            temp = temp_result / 10;
            i--;
            j--;
        }
        if (temp == 1) { // 最终结果的数字长度比任意一个都大，即temp在最后一次循环后进位了
            result.append(temp);
        }
        return result.reverse().toString();
    }

    public static String addStrings3(String num1, String num2) { // 156 / 317 testcases passed，数字过大会报错
        int n1 = 0, n2 = 0;
        for (char c: num1.toCharArray()) {
            n1 *= 10;
            n1 += c - '0';
        }
        for (char c: num2.toCharArray()) {
            n2 *= 10;
            n2 += c - '0';
        }
        return String.valueOf(n1 + n2);
    }
}
