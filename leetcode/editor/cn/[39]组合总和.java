import java.util.Arrays;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return res;
    }
    public void backtrack(int[] candidates, int start, int target){
        if (trackSum == target){
            res.add(new LinkedList<>(track));
            return;
        }
        if (trackSum > target){
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            track.addLast(candidates[i]);
            trackSum += candidates[i];
            backtrack(candidates, i, target);
            track.removeLast();
            trackSum -= candidates[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
