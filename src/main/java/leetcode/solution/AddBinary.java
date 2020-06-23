package leetcode.solution;

/**
 * 67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 */
public class AddBinary {
    public static void main(String[] args) {
        String a = "0";
        String b = "0";
        System.out.println(solution(a, b));
    }

    public static String solution(String a, String b) {
        int la = a.length() - 1;
        int lb = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (la >= 0 || lb >= 0) {
            int na = 0;
            int nb = 0;
            if (la >= 0) {
                char ca = a.charAt(la);
                na = Integer.parseInt(String.valueOf(ca));
            } else {
                na = 0;
            }
            if (lb >= 0) {
                char cb = b.charAt(lb);
                nb = Integer.parseInt(String.valueOf(cb));
            } else {
                nb = 0;
            }
            int re = na + nb + carry;
            if (re == 3) {
                sb.insert(0, "1");
                carry = 1;
            } else if (re == 2) {
                sb.insert(0, "0");
                carry = 1;
            } else if (re == 1){
                sb.insert(0, "1");
                carry = 0;
            } else {
                sb.insert(0, "0");
                carry = 0;
            }
            la--;
            lb--;
        }
        if (carry == 1) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}
