package leetcode.solution;
/**
 * 696. 计数二进制子串
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * 重复出现的子串要计算它们出现的次数。
 */
public class CountBinarySubstrings {
    

    public static void main(String[] args) {
        System.out.println(solution1("00110011"));
    }

    public static int solution1(String s) {
        int ptr = 0, n = s.length(), last = 0, ans = 0;
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while(ptr < n && s.charAt(ptr) == c){
                ptr ++;
                count++;
            }
            ans += Math.min(count, last);
            last = count;
        }
        return ans;
    }
}