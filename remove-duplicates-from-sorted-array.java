/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].

Discuss


*/

public class Solution {
    public int removeDuplicates(int[] A) {
		if (A.length==0 || A.length==1)
			return A.length;
        int i=1,j=0;
        for (;i<A.length;i++){
        	if(A[j]==A[i])
        		continue;
        	A[++j]=A[i];
        }
        return j+1;
        
    }

}