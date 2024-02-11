import java.util.Arrays;

public class _16_3SumClosest {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        int expected = 2;
        int actual = threeSumClosest2(nums, target);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    int rightNotEqual = right - 1;
                    while (left < rightNotEqual && nums[right] == nums[rightNotEqual]) { // 移动到下一个不相等的元素
                        rightNotEqual --;
                    }
                    right = rightNotEqual;
                } else {
                    int leftNotEqual = left + 1;
                    while (leftNotEqual < right && nums[left] == nums[leftNotEqual]) { // 移动到下一个不相等的元素
                        leftNotEqual ++;
                    }
                    left = leftNotEqual;
                }
                if (Math.abs(closest - target) > Math.abs(sum - target)) {
                    closest = sum;
                }
            }
        }
        return closest;
    }

    public static int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    right --;
                } else {
                    left ++;
                }
                if (Math.abs(closest - target) > Math.abs(sum - target)) {
                    closest = sum;
                }
            }
        }
        return closest;
    }
}
