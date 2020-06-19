package leetcode.solution;

/**
 * @titile 125. 验证回文串 
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 */
public class PalindromeString {
    public static void main(String[] args) {
        System.out.println(solution("a."));
    }

    private static boolean solution(String s) {
        if (s.isEmpty()) {
            return true;
        }
        char[] sArr = s.toCharArray();
        int headIndex = 0;
        int tailIndex = sArr.length - 1;

        while (headIndex < sArr.length && tailIndex > 0) {
            char head = sArr[headIndex];
            char tail = sArr[tailIndex];
            while (!Character.isLetter(head) && !Character.isDigit(head) && headIndex < sArr.length - 1) {
                headIndex++;
                head = sArr[headIndex];
            }
            if (!Character.isLetter(head) && !Character.isDigit(head)) {
                head = '\u0000';
            }
            while (!Character.isLetter(tail) && !Character.isDigit(tail) && tailIndex > 0) {
                tailIndex--;
                tail = sArr[tailIndex];
            }
            if (!Character.isLetter(tail) && !Character.isDigit(tail)) {
                tail = '\u0000';
            }
            if (Character.toLowerCase(tail) != Character.toLowerCase(head)) {
                return false;
            }
            headIndex++;
            tailIndex--;
        }
        return true;
    }
}
