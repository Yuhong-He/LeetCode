import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String input = "abcabcbb";
        int expected = 3;
        int actual = lengthOfLongestSubstring(input);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int leftIndex = -1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (leftIndex + 1 < s.length() && !set.contains(s.charAt(leftIndex + 1))) {
                set.add(s.charAt(leftIndex + 1));
                leftIndex++;
            }
            longest = Math.max(longest, leftIndex - i + 1);
        }
        return longest;
    }
}
