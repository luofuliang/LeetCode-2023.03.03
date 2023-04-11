
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> s = new Stack<>();  // 这⾥放元素索引，⽽不是元素
        int[] res = new int[n];
        for(int i=n-1; i>=0; i--){
            while (!s.isEmpty() && temperatures[s.peek()]<=temperatures[i]){
                s.pop();
            }
            res[i] = s.isEmpty() ? 0 : s.peek()-i;
            s.push(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
