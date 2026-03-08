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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int len = 1;
        ListNode temp = head;
        while(temp.next != null){
            len++;
            temp = temp.next;
        }
        temp.next = head;
        k = k%len;
        int shift = len-k;
        temp = head;
        while(shift>1){
            temp = temp.next;
            shift--;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }
}