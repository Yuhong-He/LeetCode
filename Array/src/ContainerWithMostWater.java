public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        int expected = 49;
        int actual = maxArea(height);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static int maxArea(int[] height) {
        int max = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        while (leftIndex < rightIndex) {
            max = Math.max(max, (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]));
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return max;
    }
}
