import java.util.HashMap;
import java.util.Map;

public class _509_Fibonacci {
    public static void main(String[] args) {
        int n = 4;
        int expected = 3;
        int actual = fib(n);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static Map<Integer, Integer> map = new HashMap<>();

    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int result = fib(n - 2) + fib(n - 1);
            map.put(n, result);
            return result;
        }
    }
}
