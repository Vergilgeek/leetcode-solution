package leetcode.solution;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(solution("cbbd"));
    }

    /**
     * 中心扩散法
     * 暴力法采用双指针两边夹，验证是否是回文子串。
     * <p>
     * 除了枚举字符串的左右边界以外，比较容易想到的是枚举可能出现的回文子串的“中心位置”，从“中心位置”尝试尽可能扩散出去，得到一个回文串。
     * <p>
     * 因此中心扩散法的思路是：遍历每一个索引，以这个索引为中心，利用“回文串”中心对称的特点，往两边扩散，看最多能扩散多远。
     * <p>
     * 枚举“中心位置”时间复杂度为 O(N)O(N)，从“中心位置”扩散得到“回文子串”的时间复杂度为 O(N)O(N)，因此时间复杂度可以降到 O(N^2)O(N
     * 2
     * )。
     * <p>
     * 在这里要注意一个细节：回文串在长度为奇数和偶数的时候，“回文中心”的形式是不一样的。
     * <p>
     * 奇数回文串的“中心”是一个具体的字符，例如：回文串 "aba" 的中心是字符 "b"；
     * 偶数回文串的“中心”是位于中间的两个字符的“空隙”，例如：回文串串 "abba" 的中心是两个 "b" 中间的那个“空隙”。
     */
    private static String solution(String s) {
        if (s.length() == 1) {
            return s;
        }
        char[] arr = s.toCharArray();
        String result = "";
        for (int i = 0; i < arr.length - 1; i++) {
            String odd = centerSpread(s, i, i);
            String even = centerSpread(s, i, i + 1);
            String maxLenStr = odd.length() > even.length() ? odd : even;
            result = maxLenStr.length() > result.length() ? maxLenStr : result;
        }
        return result;
    }

    private static String centerSpread(String s, int left, int right) {
        int len = s.length();
        int l = left;
        int r = right;
        while (l >= 0 && r <= len - 1) {
            if (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            } else {
                break;
            }
        }
        return s.substring(l + 1, r);
    }
}
