import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return res;
    }
    public void backtrack(int start, int n, int k){
        // base case
        if (track.size() == k){
            res.add(new LinkedList<>(track));
            return;
        }
        // 回溯算法标准框架
        for (int i = start; i <= n; i++) {
            // 选择
            track.addLast(i);
            // 通过start参数控制树枝的遍历，避免产生重复的子集。
            backtrack(i+1, n, k);
            // 撤销选择
            track.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
