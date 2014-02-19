

/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/

public class LRUCache {
	
	class Node{
			
    	Node prev;
    	Node next;
    	SimpleEntry<Integer, Integer> entry;
    	
    	public Node(int key,int value){
    		entry=new SimpleEntry<Integer, Integer>(key, value);
    		prev=null;
    		next=null;
    	}
    }
	
	private HashMap<Integer, Node> map;
	private Node head;
	private int capacity;
	private int count;
    
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.count=0;
        head=null;
        map=new HashMap<Integer, LRUCache.Node>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
        	Node node=map.get(key);
        	
        	//将get到的node放到表头
        	detach(node);
        	attach(node);
        	
        	return node.entry.getValue();
        }
        
        else return -1;
    }
    
    public void set(int key, int value) {
    	
    	//缓存中有
        if (map.containsKey(key)){
        	Node node=map.get(key);
        	node.entry.setValue(value);
        	detach(node);
        	attach(node);
        }
        
        else {
        	//缓存中没有，且未超过容量
			if((count+1)<=capacity){
				count++;
				Node node=new Node(key,value);
				attach(node);
				map.put(key, node);
				
			}
			else {
				Node tail=head.prev;
				detach(tail);
				map.remove(tail.entry.getKey());
				Node node=new Node(key, value);
				attach(node);
				map.put(key, node);
			}
		}
    }
    
  //删除指定的node
	public void detach(Node node) {
	
		
		if (node==head){
		    
		    if(node.next==node){
				head=null;
				return;
			}
			head.prev.next=head.next;
			head.next.prev=head.prev;
			
			head=head.next;
			
			return;
		}
		node.prev.next=node.next;
    	node.next.prev=node.prev;
    	
	}
	
	//将node加到表头
	public void attach(Node node){

	    
		if (head==null){
			head=node;
			head.prev=node;
			head.next=node;
		}
		else{
			node.prev=head.prev;
	    	node.next=head;
	    	head.prev.next=node;
	    	head.prev=node;
	    	head=node;
		}
		
	}
    
    
}
