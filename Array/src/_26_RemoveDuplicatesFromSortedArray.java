import java.util.Arrays;

public class _26_RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] input = {0,0,1,1,1,2,2,3,3,4};
        int expected = 5;
        int actual = removeDuplicates(input);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
        System.out.println(Arrays.toString(input));
    }

    public static int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
