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
//            System.out.println("i: " + i);
            if (i != 0) {
//                System.out.println("s.charAt(i - 1): " + s.charAt(i - 1));
                set.remove(s.charAt(i - 1));
            }
            while (leftIndex + 1 < s.length() && !set.contains(s.charAt(leftIndex + 1))) {
                set.add(s.charAt(leftIndex + 1));
//                System.out.println("s.charAt(leftIndex + 1): " + s.charAt(leftIndex + 1));
                leftIndex++;
            }
//            for (char n: set) {
//                System.out.print(n + " ");
//            }
//            System.out.println(" ");
            longest = Math.max(longest, leftIndex - i + 1);
        }
        return longest;
    }
}
