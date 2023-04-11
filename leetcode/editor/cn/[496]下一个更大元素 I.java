
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 记录 nums2 中每个元素的下⼀个更⼤元素
        int[] greater = nextGreaterElement(nums2);
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], greater[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
    public int[] nextGreaterElement(int[] num){
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[num.length];
        for (int i = num.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek()<=num[i]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(num[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
