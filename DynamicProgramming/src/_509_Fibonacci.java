public class _509_Fibonacci {
    public static void main(String[] args) {
        int n = 4;
        int expected = 3;
        int actual = fib(n);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static int fib(int n) {
        if (n <= 1) return n;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        return arr[n];
    }
}