import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        String input = "MCMXCIV";
        int expected = 1994;
        int actual = romanToInt(input);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static int romanToInt(String s) {
        s = s.replace("IV", "a");
        s = s.replace("IX", "b");
        s = s.replace("XL", "c");
        s = s.replace("XC", "d");
        s = s.replace("CD", "e");
        s = s.replace("CM", "f");
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += getValue(s.charAt(i));
        }
        return result;
    }

    public static int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            case 'a': return 4;
            case 'b': return 9;
            case 'c': return 40;
            case 'd': return 90;
            case 'e': return 400;
            case 'f': return 900;
        }
        return 0;
    }

    public static int romanToInt2(String s) {
        Map<String, Integer> map = new HashMap<>(Map.of(
                "I", 1, "V", 5, "X", 10, "L", 50,
                "C", 100, "D", 500, "M", 1000
        ));
        map.put("IV", 4); map.put("IX", 9); map.put("XL", 40);
        map.put("XC", 90); map.put("CD", 400); map.put("CM", 900);
        Map<String, List<String>> specialMap = Map.of(
                "I", List.of("V", "X"),
                "X", List.of("L", "C"),
                "C", List.of("D", "M")
        );
        String[] sArr = s.split("");
        int result = 0;
        for (int i = 0; i < sArr.length; i++) {
            if (specialMap.containsKey(sArr[i]) && i < sArr.length - 1 && specialMap.get(sArr[i]).contains(sArr[i + 1])) {
                String newDigit = sArr[i] + sArr[i + 1];
                result += map.get(newDigit);
                i += 1;
            } else {
                result += map.get(sArr[i]);
            }
        }
        return result;
    }
}
