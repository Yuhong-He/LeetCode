public class _168_ExcelSheetColumnTitle {
    public static void main(String[] args) {
        int num = 701;
        String expected = "ZY";
        String actual = convertToTitle(num);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            result.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return result.reverse().toString();
    }
}
