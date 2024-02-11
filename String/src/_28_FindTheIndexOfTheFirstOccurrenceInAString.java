public class _28_FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        int expected = 0;
        int actual = strStr(haystack, needle);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        if (haystack.equals(needle)) return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.startsWith(needle, i)) {
                return i;
            }
        }
        return -1;
    }

    public static int strStr2(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        if (haystack.equals(needle)) return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) == needle.charAt(j)) {
                        if (j == needle.length() - 1) {
                            return i;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return -1;
    }
}
