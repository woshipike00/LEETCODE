/**

Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/

 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    private HashMap<Integer, UndirectedGraphNode> map=new HashMap<Integer,UndirectedGraphNode>();
	
	
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node==null)
			return null;
		UndirectedGraphNode tempnode=new UndirectedGraphNode(node.label);
		map.put(node.label, tempnode);
		
		if(node.neighbors.size()==0)
			return tempnode;
		
		for (int i=0;i<node.neighbors.size();i++){
			int nlabel=node.neighbors.get(i).label;
			//加入自身，形成一个环
			if(nlabel==node.label)
				tempnode.neighbors.add(tempnode);
			else if (map.containsKey(nlabel)) {
				tempnode.neighbors.add(map.get(nlabel));
			}
			else {
				tempnode.neighbors.add(cloneGraph(node.neighbors.get(i)));
			}
				
		}
		return tempnode;
		        
	}
}