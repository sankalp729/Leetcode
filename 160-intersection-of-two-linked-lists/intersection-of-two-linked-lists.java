/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null) return headB;
        if(headB == null) return headA;
        ListNode tempA = headA, tempB = headB;
        while(tempA != tempB){
            if(tempA == null) tempA = headB;
            if(tempB == null) tempB = headA;
            
            if(tempA == tempB) return tempA;

            if(tempA != null) tempA = tempA.next;
            if(tempB != null) tempB = tempB.next;
        }
        return tempA;
    }
}