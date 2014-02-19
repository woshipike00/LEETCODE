/*
Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
*/

public class Solution {
    public boolean isPalindrome(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		if(x<0)
			return false;
		int div=1;
        while(x/div>=10){
        	div*=10;
        }
        while(x>=10){
        	int r=x%10;
        	int l=x/div;
        	if(r!=l)
        		return false;
        	x=(x%div)/10;
        	div/=100;
        }
        return true;
    }
}