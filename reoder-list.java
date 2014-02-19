/**

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.


 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		if(head==null || head.next==null || head.next.next==null)
			return;
		
		ListNode slow=head;
		ListNode fast=head;
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;	
			
		}
		ListNode secondhalf=slow.next;
		slow.next=null;
		ListNode secondlist=reverseList(secondhalf);
		ListNode firstlist=head;
		while(secondlist!=null){
			ListNode temp=secondlist;
			secondlist=temp.next;
			temp.next=firstlist.next;
			firstlist.next=temp;
			firstlist=firstlist.next.next;

		}
		
		
		
		
        
    }
	
	
	//遍历链表，将每一个节点插入头
	public ListNode reverseList(ListNode head){
		if (head==null || head.next==null) {
			return head;
		}
		ListNode newhead=head;
		ListNode temp=head;
		ListNode cur=head.next;
		while(cur!=null){
			temp.next=cur.next;
			cur.next=newhead;
			newhead=cur;
			cur=temp.next;
		}

		return newhead;
		
	}
}