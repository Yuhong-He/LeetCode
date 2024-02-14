import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.*;

/**
 * The Main class implements an application that reads lines from the standard input
 * and prints them to the standard output.
 */
public class Calculator {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            line = line.replaceAll(" ", "");
            double[] result = calculate(line, 0);
            DecimalFormat df = new DecimalFormat("#.#####");
            System.out.println(df.format(result[0]));
        }
    }

    private static double[] calculate(String s, int start) {
        double result;
        char operator;
        double[] values;
        int i = start;

        if(s.charAt(i) == '(') { // case start with bracket
            values = calculate(s, start + 1); // recursion
            result = values[0];
            i = (int) values[1];
        } else { // case non-bracket
            StringBuilder sb = new StringBuilder();
            if (s.charAt(i) == '-') {
                sb.append("-");
                i++;
            }
            while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.')) { // generate number
                sb.append(s.charAt(i));
                i++;
            }
            result = Double.parseDouble(sb.toString()); // first number in expression
        }

        while (i < s.length() && s.charAt(i) != ')') { // second part
            operator = s.charAt(i); // number already got in line 46, first digit of reminder must be operator
            i++;
            double nextValue;
            if (s.charAt(i) == '(') { // case bracket
                values = calculate(s, i + 1); // recursion
                nextValue = values[0]; // second number in expression
                i = (int) values[1];
            } else {
                StringBuilder sb = new StringBuilder();
                if (s.charAt(i) == '-') {
                    sb.append("-");
                    i++;
                }
                while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.')) { // generate number
                    sb.append(s.charAt(i));
                    i++;
                }
                nextValue = Double.parseDouble(sb.toString()); // second number in expression
            }

            switch(operator) {
                case '+':
                    result += nextValue;
                    break;
                case '-':
                    result -= nextValue;
                    break;
                case '*':
                    result *= nextValue;
                    break;
                case '/':
                    result /= nextValue;
                    break;
                case '^':
                    result = Math.pow(result, nextValue);
                    break;
            }
        }
        return new double[]{result, i + 1};
    }
}
