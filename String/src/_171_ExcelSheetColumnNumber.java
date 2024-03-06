public class _171_ExcelSheetColumnNumber {
    public static void main(String[] args) {
        String columnTitle = "ZY";
        int expected = 701;
        int actual = titleToNumber(columnTitle);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static int titleToNumber(String columnTitle) {
        int i = 0, result = 0;
        while (i < columnTitle.length()) {
            int num = columnTitle.charAt(i) - 'A' + 1;
            result = result * 26 + num;
            i++;
        }
        return result;
    }
}
