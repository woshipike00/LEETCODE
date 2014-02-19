/*
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Discuss

用ones记录到当前计算的变量为止，二进制1出现“1次”（mod 3 之后的 1）的数位。用twos记录到当前计算的变量为止，
二进制1出现“2次”（mod 3 之后的 2）的数位。当ones和twos中的某一位同时为1时表示二进制1出现3次，此时需要清零。
即用二进制模拟三进制计算。最终ones记录的是最终结果。


*/


public class Solution {
    public int singleNumber(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		int length=A.length;
		int once=0;
		int twice=0;
		int three=0;
        for(int i=0;i<length;i++){
        	twice |= once & A[i];
        	once ^= A[i];
        	three = twice & once;
        	twice &= ~three;
        	once &= ~three;
        }
        
        return once;
    }
}