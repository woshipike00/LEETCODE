/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

头节点前加一个节点，遍历

*/


public class Solution{
	
	 public class ListNode {
	     int val;
	     ListNode next;
	      ListNode(int x) {
	          val = x;
	         next = null;
	      }
	  }
	
	public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
        	return head;
        ListNode t=new ListNode(0);
        t.next=head;
        
        ListNode pre=t;
        ListNode post;
        while(pre.next!=null && pre.next.next!=null){
        	post=pre.next.next;
        	pre.next.next=post.next;
        	post.next=pre.next;
        	pre.next=post;
        	pre=pre.next.next;
        }
        
        return t.next;
	
	}


}