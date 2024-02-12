import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _448_FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> expected = List.of(5,6);
        List<Integer> actual = findDisappearedNumbers(nums);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx;
            if (nums[i] < 0) {
                idx = -nums[i] - 1; // 如果小于零（已经被翻转），需要翻成正的再减一，得到这个的对应指针
            } else {
                idx = nums[i] - 1; // 减一是因为指针数字比按顺序的那一位数组的顺序小一，比如[1,2,3]，数字2的位置是指针1
            }
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx]; // 如果大于0，翻转为负数
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            };
        }
        return list;
    }

    public static List<Integer> findDisappearedNumbers2(int[] nums) { // Time Limit Exceeded
        List<Integer> list = new ArrayList<>();
        List<Integer> origin = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int i = 1; i <= nums.length; i++) {
            if (!origin.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }
}
