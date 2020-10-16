package leetcode.solution;

/**
 * 977. 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 */
public class SortedSquares {

    public static void main(String[] args) {
        int[] A = new int[] { -4, -1, 2, 3, 10 };
        System.out.println(solution(A));
    }

    /**
     * 双指针
     * 可以使用两个指针分别指向位置 00 和 n-1n−1，每次比较两个指针对应的数，
     * 选择较大的那个逆序放入答案并移动指针。这种方法无需处理某一指针移动至边界的情况
     */
    public static int[] solution(int[] A) {
        int[] result = new int[A.length];
        int rIdx = A.length - 1;
        int lIdx = 0;
        int idx = A.length - 1;
        while (lIdx <= rIdx) {
            Double vR = Math.pow(A[rIdx], 2);
            Double vL = Math.pow(A[lIdx], 2);
            if (lIdx == rIdx) {
                result[idx] = vR.intValue();
                break;
            }
            if (vR > vL) {
                result[idx] = vR.intValue();
                rIdx--;
                idx--;
            } else {
                result[idx] = vL.intValue();
                idx--;
                lIdx++;
            }
        }
        return result;
    }
}
