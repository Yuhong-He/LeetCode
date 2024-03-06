import java.util.HashMap;
import java.util.Map;

public class _205_IsomorphicStrings {
    public static void main(String[] args) {
        String s = "badc", t = "baba";
        boolean expected = false;
        boolean actual = isIsomorphic(s, t);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static boolean isIsomorphic(String s, String t) { // 优化过的
        Map<Character, Character> s2t = new HashMap<>(), t2s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);
            // 对于已有映射 a -> s2t[a]，若和当前字符映射 a -> b 不匹配，
            // 说明有一对多的映射关系，则返回 false ；
            // 对于映射 b -> a 也同理
            if (s2t.containsKey(a) && s2t.get(a) != b || t2s.containsKey(b) && t2s.get(b) != a)
                return false;
            s2t.put(a, b);
            t2s.put(b, a);
        }
        return true;
    }

    public static boolean isIsomorphic2(String s, String t) { // 我写的
        if (s.length() != t.length()) return false;
        Map<Character, Character> map1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map1.containsKey(s.charAt(i))) {
                map1.put(s.charAt(i), t.charAt(i));
            } else if (t.charAt(i) != map1.get(s.charAt(i))) {
                return false;
            }
        }

        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (!map2.containsKey(t.charAt(i))) {
                map2.put(t.charAt(i), s.charAt(i));
            } else if (s.charAt(i) != map2.get(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
