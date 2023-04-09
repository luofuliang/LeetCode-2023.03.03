
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //定义虚拟头结点
        ListNode dummy = new ListNode(0), p = dummy;
        p.next = head;
        //定义找倒数第n个节点的函数
        ListNode ans = findN(p, n+1);
        ans.next = ans.next.next;
        return dummy.next;
    }

    public ListNode findN(ListNode head, int x){
        ListNode p1 = head;
        for (int i = 0; i < x; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
