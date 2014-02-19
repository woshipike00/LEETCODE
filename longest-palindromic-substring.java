/*

Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

见evernote



*/

public class Solution {
    public String longestPalindrome(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        String newstring=new String("#");
        int length=s.length();
        for (int i=0;i<length;i++){
        	newstring+=s.charAt(i)+"#";
        }
        int[] p=new int[newstring.length()];
        p[0]=0;
        p[1]=1;
        int center=1;
        int right=2;
        for(int i=2;i<newstring.length();i++){
        	if(i>right){
        		center=right;
        		right=center+p[center];
        	}
        	
        	if(i<=right){
        		int mirror=2*center-right;
            	if(i+p[mirror]>right)
            		p[i]=right-i;
            	else
            		p[i]=p[mirror];
        	}
        	
        	
        	while((i-p[i]-1)>=0 && (p[i]+i+1)<newstring.length() && newstring.charAt(p[i]+i+1)==newstring.charAt(i-p[i]-1) )
        		p[i]++;
        	
        	
        }
        
        int longest=0;
        int c=0;
        for (int i=0;i<newstring.length();i++){
        	
        	if(p[i]>longest){
        		longest=p[i];
        		c=i;
        	}
        }
        return newstring.substring(c-longest,c+longest+1).replace("#", "");
    }
	
}