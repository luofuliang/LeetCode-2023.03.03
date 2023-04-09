//给你两个字符串 map1 和 map2 ，写一个函数来判断 map2 是否包含 map1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，map1 的排列之一是 map2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：map1 = "ab" map2 = "eidbaooo"
//输出：true
//解释：map2 包含 map1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：map1= "ab" map2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= map1.length, map2.length <= 10⁴ 
// map1 和 map2 仅包含小写字母 
// 
//
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 893 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //1.定义需要维护的变量
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char c : s1.toCharArray()){
            map1.put(c, map1.getOrDefault(c,0)+1);
        }
        //2.定义滑动窗口，并开始滑动
        int start=0;
        for(int end=0; end<s2.length(); end++){
            char cur = s2.charAt(end);
            map2.put(cur, map2.getOrDefault(cur,0)+1);
            if(map1.equals(map2)){
                return true;
            }
            if(end >= s1.length()-1){
                char old = s2.charAt(start);
                int count = map2.get(old) - 1;
                if(count == 0)
                    map2.remove(old);
                if(count > 0){
                    map2.put(old, count);
                }
                start++;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
