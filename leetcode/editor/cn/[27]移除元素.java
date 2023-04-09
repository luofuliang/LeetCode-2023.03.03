
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int fast=0, slow=0;
        while (fast < nums.length){
            if(nums[fast] != val){
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow++;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
