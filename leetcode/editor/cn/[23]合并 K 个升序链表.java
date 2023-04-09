
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        //虚拟头结点
        ListNode head = new ListNode(0), p = head;
        //优先级队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(((o1, o2) -> o1.val - o2.val));

        for(ListNode list : lists){
            if(list!=null)
                pq.offer(list);
        }

        //优先队列不空，出一个最小节点，然后将最小节点的下一个节点入队
        while (!pq.isEmpty()){
            ListNode minNode = pq.poll();
            p.next = minNode;
            p = p.next;
            if(minNode.next != null){
                pq.offer(minNode.next);
            }
        }

        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
