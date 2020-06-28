package leetcode.solution;

import java.util.stream.IntStream;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例: 
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        int s = 213;
        int[] nums = {12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12};
        System.out.println(solution2(s, nums));
    }

    /**
     * 暴力法
     */
    public static int solution1(int s, int[] nums) {
        int sum = IntStream.of(nums).sum();
        if (sum < s) {
            return 0;
        }
        if (sum == s) {
            return nums.length;
        }
        int result = nums.length;
        for (int idx1 = 0; idx1 < nums.length; idx1++) {
            int total = nums[idx1];
            int record = 1;
            if (total >= s) {
                return 1;
            }
            for (int idx2 = idx1 + 1; idx2 < nums.length; idx2++) {
                total = total + nums[idx2];
                record++;
                if (total >= s) {
                    result = Math.min(result, record);
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 双指针
     */
    public static int solution2(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
