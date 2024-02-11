import java.util.HashMap;
import java.util.Map;

public class _383_RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        boolean expected = true;
        boolean actual = canConstruct(ransomNote, magazine);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> mapMagazine = new HashMap<>();
        for (char c: magazine.toCharArray()) {
            if (mapMagazine.containsKey(c)) {
                mapMagazine.put(c, mapMagazine.get(c) + 1);
            } else {
                mapMagazine.put(c, 1);
            }
        }
        Map<Character, Integer> mapNote = new HashMap<>();
        for (char c: ransomNote.toCharArray()) {
            if (mapNote.containsKey(c)) {
                mapNote.put(c, mapNote.get(c) + 1);
                if (mapMagazine.get(c) < mapNote.get(c)) {
                    return false;
                }
            } else {
                mapNote.put(c, 1);
                if (!mapMagazine.containsKey(c)) {
                    return false;
                }
            }
        }
        return true;
    }
}
