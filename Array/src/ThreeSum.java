import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[] {-1,0,1,2,-1,-4};
        int[][] expected = new int[][] {{-1,-1,2}, {-1,0,1}};
        List<List<Integer>> actual = threeSum(nums);
        System.out.println(Arrays.deepToString(expected));
        System.out.println(Arrays.deepToString(actual.toArray()));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int current = 0; current < nums.length; current++) {
            if(nums[current] > 0) break;
            if(current > 0 && nums[current] == nums[current - 1]) continue;
            int left = current + 1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[current] + nums[left] + nums[right];
                if(sum == 0) {
                    result.add(List.of(nums[current], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++; // 去重，算法优化！
                    while (left < right && nums[right] == nums[right - 1]) right--; // 去重，算法优化！
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    // over time
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int leftIndex = 0;
            int rightIndex = nums.length - 1;
            while (leftIndex < rightIndex && leftIndex != i && rightIndex != i) {
                int currSum = nums[leftIndex] + nums[rightIndex];
                if ((currSum + nums[i]) > 0) {
                    rightIndex--;
                } else if ((currSum + nums[i]) < 0) {
                    leftIndex++;
                } else {
                    List<Integer> newPair = List.of(nums[i], nums[leftIndex], nums[rightIndex]);
                    if (!Arrays.deepToString(result.toArray()).contains(Arrays.deepToString(newPair.toArray()))) {
                        result.add(newPair);
                    }
                    leftIndex++;
                }
            }
        }
        return result;
    }
}
