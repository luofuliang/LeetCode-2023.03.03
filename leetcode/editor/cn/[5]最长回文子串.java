
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i+1);

//            res = res.length() > s1.length() ? res : s1;
//            res = res.length() > s2.length() ? res : s2;
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }
    public String palindrome(String s, int i, int j){
        while (i>=0 && j<s.length() && (s.charAt(i) == s.charAt(j))){
            i--;
            j++;
        }
        return s.substring(i+1, j);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
