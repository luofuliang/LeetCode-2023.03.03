import java.util.Arrays;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    // 记录 track 中的元素之和
    int trackSum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return res;
    }
    public void backtrack(int[] candidates, int start, int target){
        if (trackSum > target)
            return;
        if(trackSum == target){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i-1]){
                continue;
            }
            track.addLast(candidates[i]);
            trackSum += candidates[i];
            backtrack(candidates, i+1, target);
            track.removeLast();
            trackSum -= candidates[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
