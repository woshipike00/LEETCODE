/**
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?


 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?

use fast runner slow runner ,if fast runner catches up with slow runner , there is a cycle
when fast and slow meets , use another pointer from the beginning , they will meet at the beginning of the cycle



 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
        	fast=fast.next.next;
        	slow=slow.next;
        	if(fast!=slow)
        		continue;
            ListNode newpointer=head;
            while(newpointer!=slow){
                newpointer=newpointer.next;
                slow=slow.next;
            }
            return newpointer;
        }
        return null;
        
    }
}