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
    public ListNode swapPairs(ListNode head) {
        ListNode target = head;
        boolean isChange = true;
        ListNode prev = null;
        while(target != null)
        {
            isChange = !isChange;
            if(isChange)
            {
                int tmp = target.val;
                target.val = prev.val;
                prev.val = tmp;
            }

            prev = target;
            target = target.next;
        }

        return head;
    }
}