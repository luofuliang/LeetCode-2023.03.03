
//leetcode submit region begin(Prohibit modification and deletion)
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
    public ListNode partition(ListNode head, int x) {
        ListNode h1 = new ListNode(-1), p1 = h1;
        ListNode h2 = new ListNode(-1), p2 = h2;
        ListNode p = head;
        while (p!=null){
            if(p.val < x){
                p1.next = p;
                p1 = p1.next;
            }else{
                p2.next = p;
                p2 = p2.next;
            }
            p = p.next;
        }
        p2.next = null;     //避免形成环：5后面还连着2, 2 4 3 5 2
        p1.next = h2.next;
        return h1.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
