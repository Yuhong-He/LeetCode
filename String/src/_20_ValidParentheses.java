import java.util.*;

public class _20_ValidParentheses {
    public static void main(String[] args) {
        String input = "){";
        boolean expected = false;
        boolean actual = isValid(input);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static boolean isValid(String s) {
        if (s.length() <= 1) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<>();
        for (char c: s.toCharArray()) {
            if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '(') {
                stack.push(')');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> pairs = Map.of(
                ')', '(',
                ']', '[',
                '}', '{'
        );
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid3(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> map = Map.of(
                ')', '(',
                ']', '[',
                '}', '{'
        );
        List<Character> list = List.of('(', '[', '{');
        List<Character> queue = new ArrayList<>();
        int order1 = 0;
        int order2 = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (list.contains(c)) {
                order1++;
                queue.add(c);
            } else {
                order2++;
                if (queue.isEmpty()) {
                    return false;
                }
                if (queue.get(queue.size() - 1) == map.get(c)) {
                    queue.remove(queue.size() - 1);
                } else {
                    return false;
                }
            }
        }
        return order1 == order2;
    }
}
