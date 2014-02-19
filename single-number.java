/*Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?


import java.util.Hashtable;

public class Solution {
    public int singleNumber(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		int length=A.length;
        Hashtable<Integer,Integer> table =new Hashtable<Integer,Integer>();
        for (int i=0;i<length;i++){
        	if(table.containsKey(A[i]))
        		table.remove(A[i]);
        	else {
				table.put(A[i], 0);
			}
        }
        return table.keys().nextElement();
        
        
    }
}*/

public class Solution {
    public int singleNumber(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int result=0;
        for (int i=0;i<A.length;i++){
            result^=A[i];
        }
        return result;
        
    }
}