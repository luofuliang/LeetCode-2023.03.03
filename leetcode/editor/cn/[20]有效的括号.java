
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> leftStack = new Stack<>();
        char[] c = s.toCharArray();
        for (char ch : c){
            if (ch=='(' || ch=='[' || ch=='{'){
                leftStack.push(ch);
            }else {
                if (!leftStack.isEmpty() && traverse(ch)==leftStack.peek())
                    leftStack.pop();
                else
                    return false;
            }
        }
        return leftStack.isEmpty();
    }
    public char traverse(char ch){
        if (ch == ')') return '(';
        else if (ch == ']') return '[';
        else return '{';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
