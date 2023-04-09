import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 备忘录，存储 used 数组的状态
    HashMap<String, Boolean> memo = new HashMap<>();

    // 从桶的视角来收取数
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length < k)    return false;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0)   return false;
        int target = sum / k;
        int[] used = new int[nums.length];
        return backtrack(k, 0, nums, 0, used, target);
    }

    public boolean backtrack(int k, int backetSum, int[] nums, int start, int[] used, int target){
        if (k == 0){
            return true;
        }
        String state = Arrays.toString(used);
        if (backetSum == target){
            // 装满了当前桶，递归穷举下一个桶的选择
            // 让下一个桶从nums[0]开始选数字，同时backSum重置
            boolean res = backtrack(k-1, 0, nums, 0, used, target);
            memo.put(state, res);
            return res;
        }
        if (memo.containsKey(state)){
            return memo.get(state);
        }
        for (int i = start; i < nums.length; i++) {
            if (used[i] == 1)
                continue;
            if (backetSum + nums[i] > target){
                continue;
            }
            backetSum += nums[i];
            used[i] = 1;
            if (backtrack(k, backetSum, nums, i+1, used, target))
                return true;
            backetSum -= nums[i];
            used[i] = 0;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
