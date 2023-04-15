
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 优先队列
    HashMap<Integer, Integer> map = new HashMap<>();
    public int[] topKFrequent(int[] nums, int k) {
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (o1, o2) -> o1.getValue() - o2.getValue()
        );
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
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
