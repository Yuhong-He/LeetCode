import java.util.Arrays;

public class _1_BubbleSort {
    public static void main(String[] args) {
        int[] input = new int[] {4,7,3,8,2,5};
        int[] expected = new int[] {2,3,4,5,7,8};
        int[] actual = bubbleSort(input);
        System.out.println("expected: " + Arrays.toString(expected));
        System.out.println("actual: " + Arrays.toString(actual));
    }

    public static int[] bubbleSort(int[] arr) { // improved
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true; // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            for (int j = 0; j < arr.length - 1 - i; j++) { // j < arr.length - 1 - i，已经有i个最大元素排在最后，不需要再比较
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }

    public static int[] bubbleSort2(int[] arr) { // basic
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
