import java.util.Arrays;

/*
 * 选择排序：每次循环从数组中找到未排序部分的最小的元素，放在未排序的最前面（已排序的最后面）
 * */
public class _2_SelectionSort {
    public static void main(String[] args) {
        int[] input = new int[] {4,7,3,8,2,5};
        int[] expected = new int[] {2,3,4,5,7,8};
        int[] actual = selectionSort(input);
        System.out.println("expected: " + Arrays.toString(expected));
        System.out.println("actual: " + Arrays.toString(actual));
    }

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { // i < arr.length - 1，防止内层遍历j的数组越界
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) { // j = i + 1，从i的下一个开始比较
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
        return arr;
    }
}
