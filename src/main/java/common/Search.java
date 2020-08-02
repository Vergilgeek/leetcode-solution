package common;

public class Search {


    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,5,6,7};
        int target = 5;
        System.out.println(binarySearch(nums, target));
    }

    /**
     * 二分查找
     * @param nums 数组
     * @param target 目标数
     * @return 坐标
     */
    public static int binarySearch(int[] nums , int target){
        int low = 0;
        int high = nums.length - 1;
        while (low < high){
            int mid = low + (high - low) / 2;
            if (nums[mid] == target){
                return nums[mid];
            } else if (nums[mid] > target){
                high = mid - 1;
            } else if (nums[mid] < target){
                low = mid + 1;
            }
        }
        return low;
    }
}
