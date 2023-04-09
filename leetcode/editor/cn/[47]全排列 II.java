import java.util.Arrays;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new int[nums.length+1];
        backtrack(nums);
        return res;
    }
    public void backtrack(int[] nums){
        if (track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1){
                continue;
            }
            // 添加剪枝逻辑：
            // 如果相邻两数相同，但前一个数未被访问，跳过本次循环
            if (i > 0 && nums[i] == nums[i-1] && used[i-1] == 0){
                continue;
            }
            track.addLast(nums[i]);
            used[i] = 1;
            backtrack(nums);
            track.removeLast();
            used[i] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
