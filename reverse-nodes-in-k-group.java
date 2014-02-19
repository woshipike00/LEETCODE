/**


Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

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
    public ListNode reverseKGroup(ListNode head, int k) {
		if (head==null || k==0)
			return head;
		ListNode prehead=new ListNode(0);
		
		//prehead 为 head 之前的一个指针，current指向需要翻转的组的前一个指针，next为该组的最后一个指针
		prehead.next=head;
        ListNode current=prehead;
        ListNode next=current;
        int count=0;
        while(next!=null){
        	
        	
        	if(count%k!=0 || count==0){
        		next=next.next;
        		count++;
        		continue;
        	}
        	
        	//将组里的k个指针反转，一个个将头的指针查到末尾
        	ListNode newcurrent=current.next; //记录下一个current的位置
        	ListNode tail=next.next;
        	for (int i=0;i<k-1;i++){
        		ListNode temp=current.next;
        		current.next=current.next.next;
        		temp.next=tail;
        		next.next=temp;
        		tail=temp;	   		
        	}
        	
        	current=newcurrent;
        	next=current.next;
        	count++;
        }
        
        return prehead.next;
    }
}