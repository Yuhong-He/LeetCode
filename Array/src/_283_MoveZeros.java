import java.util.Arrays;

public class _283_MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        int[] expected = {1,3,12,0,0};
        System.out.println("expected: " + Arrays.toString(expected));
        moveZeroes(nums);
        System.out.println("actual: " + Arrays.toString(expected));
    }

    public static void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j++;
            } else if(j > 0) {
                int temp = nums[i];
                nums[i] = 0;
                nums[i - j] = temp;
            }
        }
    }

    public static void moveZeroes2(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for(int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
