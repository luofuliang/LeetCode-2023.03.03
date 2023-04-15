
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 优先队列
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    if(o1.getValue().equals(o2.getValue())){
                        // 如果出现频率相同，按照字符串字典序排序
                        return o2.getKey().compareTo(o1.getKey());
                    }else{
                        // 队列按照字符串出现频率从小到大排序
                        return o1.getValue().compareTo(o2.getValue());
                    }
                }
        );
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            pq.offer(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }
        // 把出现次数最多的 k 个字符串返回
        LinkedList<String> res = new LinkedList<>();
        while(!pq.isEmpty()){
            res.addFirst(pq.poll().getKey());
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
