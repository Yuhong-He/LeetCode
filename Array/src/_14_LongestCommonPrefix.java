public class _14_LongestCommonPrefix {
    public static void main(String[] args) {
        String[] input = {"flower","flower","flower","flower"};
        String expected = "flower";
        String actual = longestCommonPrefix(input);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if(length == 0) {
            return "";
        }
        int first = strs[0].length();
        for (int i = 0; i < first; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        int prefixLong = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            boolean canContinue = true;
            char currentChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                try {
                    if (currentChar != strs[j].charAt(i)) {
                        canContinue = false;
                        break;
                    }
                } catch (Exception e) {
                    canContinue = false;
                    break;
                }
            }
            prefixLong = Math.max(prefixLong, i);
            if (!canContinue) {
                break;
            }
            if (i == strs[0].length() - 1) {
                prefixLong += 1;
            }
        }
        return strs[0].substring(0, prefixLong);
    }
}
