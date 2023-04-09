
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int l = leftSR(nums, target);
        int r = rightSR(nums, target);
        res[0] = l; res[1] = r;
        return res;
    }

    public int leftSR(int[] nums, int target){
        int left = 0, right = nums.length;
        while (left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target)
                right = mid;
            else if(nums[mid] > target)
                right = mid;
            else
                left = mid + 1;
        }
        if (left == nums.length) return -1;
        return nums[left]==target ? left : -1;
    }
    public int rightSR(int[] nums, int target){
        int left = 0, right = nums.length;
        while (left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target)
                left = mid + 1;
            else if(nums[mid] > target)
                right = mid;
            else
                left = mid + 1;
        }
        if (left-1 < 0) return -1;
        return nums[left -1]==target ? left-1 : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
