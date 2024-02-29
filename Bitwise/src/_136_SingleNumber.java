public class _136_SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        int expected = 4;
        int actual = singleNumber(nums);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num: nums) {
            result = result ^ num;
        }
        return result;
    }
}
