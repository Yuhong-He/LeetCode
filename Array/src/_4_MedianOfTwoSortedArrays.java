import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _4_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 3};
        int[] nums2 = new int[] {3, 4};
        double expected = 2.5;
        double actual = findMedianSortedArrays(nums1, nums2);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        list1.addAll(list2);
        int[] nums = list1.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(nums);
        if (nums.length % 2 == 0) {
            return (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.0;
        } else {
            return nums[Math.abs(nums.length / 2)];
        }
    }
}
