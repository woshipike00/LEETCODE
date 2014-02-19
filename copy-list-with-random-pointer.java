/**
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
在原来每两个节点中间插入一个复制的节点
第二轮恢复random节点，第三轮恢复next节点

 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        if(head==null)
	            return null;
	        
	    	RandomListNode temp=head;
	    	
	    	//copy every node like A->A'->B->B'...
	        while (temp!=null){
	        	RandomListNode tempNode=new RandomListNode(temp.label);
	        	tempNode.next=temp.next;
	        	temp.next=tempNode;
	        	temp=temp.next.next;
	        }
	        //restore the random pointer
	        RandomListNode newhead=head.next;
	        temp=head;
	        while(temp!=null){
	        	if (temp.random==null){
	        		temp.next.random=null;
	        	}
	        	else {
		        	temp.next.random=temp.random.next;

				}
	        	temp=temp.next.next;
	        }
	        
	        temp=head;
	        RandomListNode temp1=temp.next;
	        while(temp1.next!=null){
	        	temp.next=temp1.next;
	        	temp1.next=temp1.next.next;
	        	temp=temp.next;
	        	temp1=temp1.next;
	        }
	        
	        temp.next=null;
	        return newhead;
	        
	    }
}