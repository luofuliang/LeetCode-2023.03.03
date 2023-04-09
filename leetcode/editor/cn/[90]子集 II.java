import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        backtrack(nums, 0);
        return res;
    }
    public void backtrack(int[] nums, int start){
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            // 剪枝逻辑，值相同的相邻树枝，只遍历第⼀条
            // 第一条树枝i=start，直接遍历，第二条树枝i>start
            if (i > start && nums[i] == nums[i-1])
                continue;
            track.addLast(nums[i]);
            backtrack(nums, i+1);
            track.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
