/*
Sort a linked list in O(n log n) time using constant space complexity.
*/


public ListNode sortList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		
		if(head==null || head.next==null)
			return head;
		
		//找到中间节点
		ListNode slow=head;
		ListNode fast=head;
		//两个节点的时候不跑
		while(fast.next!=null && fast.next.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		fast=slow.next;
		slow.next=null;
		slow=head;
		
		slow=sortList(slow);
		fast=sortList(fast);
		
		return merge(slow, fast);
		
		
        
    }
	
	
	//合并两个链表
	public ListNode merge(ListNode h1,ListNode h2){
		
		if(h1==null)
			return h2;
		if(h2==null)
			return h1;
		
		ListNode head= new ListNode(0);
		ListNode tail;

		tail=head;
		while(h1!=null && h2 !=null){
			if (h1.val<=h2.val){
				tail.next=h1;
				h1=h1.next;
				tail=tail.next;
			}
			else {
				tail.next=h2;
				h2=h2.next;
				tail=tail.next;
			}
		}
		if(h1==null)
			tail.next=h2;
		else
			tail.next=h1;
		return head.next;
			
	}