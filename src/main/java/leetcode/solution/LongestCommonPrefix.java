package leetcode.solution;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] param = new String[]{"flower", "flow", "flight"};
        System.out.println(solution1(param));
    }

    /**
     * 二分查找
     * 最长公共前缀的长度不会超过字符串数组中的最短字符串的长度。用 {minLength}minLength 表示字符串数组中的最短字符串的长度，
     * 则可以在 [0,\textit{minLength}][0,minLength] 的范围内通过二分查找得到最长公共前缀的长度。每次取查找范围的中间值 {mid}mid，
     * 判断每个字符串的长度为 \textit{mid}mid 的前缀是否相同，如果相同则最长公共前缀的长度一定大于或等于 {mid}mid，
     * 如果不相同则最长公共前缀的长度一定小于 {mid}mid，通过上述方式将查找范围缩小一半，直到得到最长公共前缀的长度。
     *
     */
    public static String solution1(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(str.length(), minLength);
        }
        int low = 0;
        int high = minLength;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    public static boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].startsWith(str0)) {
                return false;
            }
        }
        return true;
    }
}
