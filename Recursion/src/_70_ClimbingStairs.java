import java.util.HashMap;
import java.util.Map;

public class _70_ClimbingStairs {
    public static void main(String[] args) {
        int n = 3;
        int expected = 3;
        int actual = climbStairs2(n);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    static Map<Integer, Integer> map = new HashMap<>();
    public static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (map.get(n) != null) {
            return map.get(n);
        } else {
            int result = climbStairs(n - 1) + climbStairs(n - 2);
            map.put(n, result);
            return result;
        }
    }

    public static int climbStairs2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int result = 0;
        int pre = 2;
        int prePre = 1;
        for (int i = 3; i <= n; i++) {
            result = pre + prePre;
            prePre = pre;
            pre = i;
        }
        return result;
    }
}
