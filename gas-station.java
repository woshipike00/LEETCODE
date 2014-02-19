/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.


首先 如果所有 gas[i]-cost[i]之和大于等于0，那么一定有解，可以这样构造，total为已有gas[i]-cost[i]，如果可以向后走就向后走
如果不能就向前直到total>=0，那么一定存在这么一个非负的序列

接下来只要遍历，已扫过的部分要是sum<0，那么其中每一个都不可能作为起点

*/

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index=0;
        int total=0;
        int sum=0;
        for (int i=0;i<gas.length;i++){
        	total+=gas[i]-cost[i];
        	sum+=gas[i]-cost[i];
        	if(sum<0){
        		sum=0;
        		index=i+1;
        	}
        }
        if(total>=0)
        	return index;
        return -1;
        
    }
}