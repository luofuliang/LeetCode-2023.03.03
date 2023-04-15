
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 使用优先队列
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> valToFreq = new HashMap<>();
        // 统计每个元素出现的频率
        for (int v : nums) {
            valToFreq.put(v, valToFreq.getOrDefault(v, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (entry1, entry2) -> entry1.getValue() - entry2.getValue()
        );
        Set<Map.Entry<Integer, Integer>> set = valToFreq.entrySet();
        for(Map.Entry<Integer, Integer> entry : set){
            pq.offer(entry);
            if (pq.size() > k){
                pq.poll();
            }
        }
        int[] res = new int[k];
        for (int i = k-1; i >= 0; i--) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
