
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minAddToMakeValid(String s) {
        // 尝试插入的左括号个数
        int res = 0;
        // 还需要的右括号个数
        int need = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(')
                need++;
            else{
                need--;
                if (need == -1){
                    need = 0;
                    res++;
                }
            }
        }
        return res+need;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
