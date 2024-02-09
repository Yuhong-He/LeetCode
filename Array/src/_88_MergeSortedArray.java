import java.util.Arrays;

public class _88_MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        for(int index = m + n - 1; index >= 0; index--) { // index >= 0!!
            if (index1 < 0) { // nums1 empty
                nums1[index] = nums2[index2];
                index2--;
            } else if (index2 < 0) { // nums1 empty
                nums1[index] = nums1[index1];
                index1--;
            } else if(nums1[index1] > nums2[index2]) {
                nums1[index] = nums1[index1];
                index1--;
            } else {
                nums1[index] = nums2[index2];
                index2--;
            }
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int index1 = m - 1;
        int index2 = n - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[index] = nums1[index1];
                index1 -= 1;
            } else {
                nums1[index] = nums2[index2];
                index2 -= 1;
            }
            index -= 1;
        }
        while (index2 >= 0) {
            nums1[index] = nums2[index2];
            index2 -= 1;
            index -= 1;
        }
    }
}
