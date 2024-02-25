import java.util.Arrays;

/*
 * 插入排序：每次循环将未排序的第一个元素插入已排序的部分的合适位置，已排序的比他大的元素需要向后移一格
 * */
public class _3_InsertionSort {
    public static void main(String[] args) {
        int[] input = new int[] {4,7,3,8,2,5};
        int[] expected = new int[] {2,3,4,5,7,8};
        int[] actual = insertionSort(input);
        System.out.println("expected: " + Arrays.toString(expected));
        System.out.println("actual: " + Arrays.toString(actual));
    }

    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) { // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
            int temp = arr[i];
            int j = i;
            while (j > 0 && temp < arr[j - 1]) { // 从已经排序的序列最右边的开始比较，找到比其小的数
                arr[j] = arr[j - 1];
                j--;
            }
            if (j != i) { // 存在比其小的数，插入
                arr[j] = temp;
            }
        }
        return arr;
    }
}
