
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        Merge merge = new Merge();
        merge.sort(nums);
        return nums;
    }
}
class Merge{
    // ⽤于辅助合并有序数组
    static int[] tmp;
    public static void sort(int[] nums){
        tmp = new int[nums.length];
        sort(nums, 0, nums.length-1);
    }
    public static void sort(int[] nums, int start, int end){
        // base case
        if (start == end)
            return;
        int mid = start + (end-start)/2;
        sort(nums, start, mid);
        sort(nums, mid+1, end);

        // 后序位置
        merge(nums, start, mid, end);
    }
    public static void merge(int[] nums, int start, int mid, int end){
        for (int i = start; i <= end; i++) {
            tmp[i] = nums[i];
        }
        // 数组双指针技巧，合并两个有序数组
        int i=start, j=mid+1;
        for (int k = start; k <= end; k++) {
            if (i == mid+1){            // 左半边数组已全部被合并
                nums[k] = tmp[j++];
            }else if (j == end+1){      // 右半边数组已全部被合并
                nums[k] = tmp[i++];
            }else if (tmp[i] > tmp[j]){
                nums[k] = tmp[j++];
            }else {
                nums[k] = tmp[i++];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
