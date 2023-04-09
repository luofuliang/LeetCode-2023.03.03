//给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//输出：6
//解释：[1,1,1,0,0,1,1,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 6。 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//输出：10
//解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 10。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1 
// 0 <= k <= nums.length 
// 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 526 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestOnes(int[] nums, int k) {
        //1.定义需要维护的变量
        HashMap<Integer, Integer> map = new HashMap<>();
        int max_len = 0;

        //2.定义滑动窗口并移动
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            //3.滑动end指针，并维护变量
            int tail = nums[end];
            map.put(tail, map.getOrDefault(tail, 0)+1);
            if(map.getOrDefault(0,0) <= k){
                max_len = Math.max(max_len, end-start+1);
            }
            //4.滑动start指针，并维护变量，固定窗口长度用if，不固定窗口长度用while
            while (map.getOrDefault(0,0) > k){
                int head = nums[start];
                map.put(head, map.get(head)-1);
                start++;
            }
        }
        return max_len;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
