import java.util.*;

public class LetterCombinationOfAPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";
        String[] expected = {"ad","ae","af","bd","be","bf","cd","ce","cf"};
        List<String> actual = letterCombinations(digits);
        System.out.println("expected: \t" + Arrays.toString(expected));
        System.out.println("actual: \t" + Arrays.toString(actual.toArray()));
    }

    static Map<Character, List<String>> keyboards = Map.of(
            '1', List.of("1"),
            '2', List.of("a", "b", "c"),
            '3', List.of("d", "e", "f"),
            '4', List.of("g", "h", "i"),
            '5', List.of("j", "k", "l"),
            '6', List.of("m", "n", "o"),
            '7', List.of("p", "q", "r", "s"),
            '8', List.of("t", "u", "v"),
            '9', List.of("w", "x", "y", "z"),
            '0', List.of("0")
    );

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        String[] currentNumber = new String[digits.length()];
        helper(0, digits, result, currentNumber);
        return result;
    }

    public static void helper(int i, String digits, List<String> result, String[] currentNumber) {
        if (i == digits.length()) {
            String currentNumberStr = String.join("", currentNumber);
            result.add(currentNumberStr);
        } else {
            List<String> list = keyboards.get(digits.charAt(i));
            for (String s: list) {
                currentNumber[i] = s;
                helper(i + 1, digits, result, currentNumber);
            }
        }
    }
}
