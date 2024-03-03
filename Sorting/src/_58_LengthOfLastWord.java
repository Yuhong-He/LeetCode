public class _58_LengthOfLastWord {
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        int expected = 4;
        int actual = lengthOfLastWord(s);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static int lengthOfLastWord(String s) { // 更漂亮的写法
        if(s == null || s.isEmpty()) return 0;
        int length = 0;
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == ' '){
                if(length == 0) continue;
                break;
            }
            length++;
        }
        return length;
    }

    public static int lengthOfLastWord2(String s) { // 自己写的
        int length = 0;
        boolean foundWord = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                foundWord = true;
            }
            if (foundWord && s.charAt(i) != ' ') {
                length++;
            } else if (foundWord && s.charAt(i) == ' ') {
                break;
            }
        }
        return length;
    }
}
