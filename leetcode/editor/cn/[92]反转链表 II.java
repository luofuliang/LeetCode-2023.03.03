
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
    // 递归解法
    // 需要从递归翻转整条链表的算法开始，推导出递归翻转前 N 个节点的算法，最后改写出递归翻转区间内的节点的解法代码。
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // base case
        if (left == 1){
            return reverseN(head, right);
        }
        // 前进到反转的起点进行触发 base case
        head.next = reverseBetween(head.next, left-1, right-1);
        return head;
    }
    ListNode next = null;   // 后驱节点
    public ListNode reverseN(ListNode head, int n){
        if (n == 1){
            next = head.next;   // 记录第n+1个节点
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n-1 );

        // 让反转之后的 head 节点和后面的节点连起来
        head.next.next = head;
        head.next = next;
        return last;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
