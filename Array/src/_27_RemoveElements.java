import java.util.Arrays;

public class _27_RemoveElements {
    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        int val = 2;
        int expected = 5;
        int actual = removeElement(arr, val);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
        System.out.println(Arrays.toString(arr));
    }

    public static int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}
