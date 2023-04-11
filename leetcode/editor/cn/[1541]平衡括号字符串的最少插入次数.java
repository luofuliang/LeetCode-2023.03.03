
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minInsertions(String s) {
        char[] c = s.toCharArray();
        int res = 0;    // 插入左右括号个数
        int need = 0;   //  还需要的右括号个数
        for (int i = 0; i < s.length(); i++) {
            if (c[i] == '('){
                need += 2;
                if (need%2 == 1){   // 当遇到左括号时，若对右括号的需求量为奇数，需要插⼊1个右括号
                    res++;
                    need--;
                }
            }
            else {
                need--;
                if (need == -1){    // 意味着我们遇到⼀个多余的右括号，显然需要插⼊⼀个左括号
                    res++;
                    need = 1;
                }
            }
        }
        return res + need;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
