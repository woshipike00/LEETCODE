/**


You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8



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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        int t=0;
	        ListNode list1=l1;
	        ListNode list2=l2;
	        ListNode sum=new ListNode(0);
	        ListNode head=sum;
	        while(list1!=null && list2!=null){
	        	
	        	int temp=list1.val+list2.val+t;
	        	if(temp>=10){
	        		sum.next=new ListNode(temp-10);
	        		t=1;	
	        	}
	        	else {
					sum.next=new ListNode(temp);
					t=0;
				}
	        	list1=list1.next;
        		list2=list2.next;
        		sum=sum.next;
	        }
	        if(list1==null){
	        	if(t==0)
	        		sum.next=list2;
	        	else
	        		addone(list2,sum);
	        }
	        else{
	        	if(t==0)
	        		sum.next=list1;
	        	else
	        		addone(list1,sum);
	        }
	        return head.next;
	        
	    }
	 
	 public void addone(ListNode list,ListNode sum){
		 ListNode temp=list;
		 int t=1;
		 while(temp!=null){
			 int add=temp.val+t;
			 if(add>=10){
				 t=1;
				 sum.next=new ListNode(add-10);
			 }
			 else {
				t=0;
				sum.next=new ListNode(add);
				
			}
			temp=temp.next;
			sum=sum.next;
		 }
		 if(t==1)
			 sum.next=new ListNode(1);
		 
	 }
	
	
}