/*
Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.

一个个扫描字符，若没有出现则加入map，出现则将start移到上次出现这个字符的后面，并将前面的字符删除
*/


public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(s.length()==0 || s.length()==1)
            return s.length();
        
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		int start=0;
		int maxlength=0;
		
		for (int i=0;i<s.length();i++){
			if (!map.containsKey(s.charAt(i)))
				map.put(s.charAt(i),i);
			else {
				int templength=i-start;
				if(templength>maxlength)
					maxlength=templength;
				int newstart=map.get(s.charAt(i))+1;
				for (int k=start;k<newstart;k++)
					map.remove(s.charAt(k));
				
				start=newstart;
				map.put(s.charAt(i), i);
			}
		}
		int tail=s.length()-start;
		if(tail>maxlength)
			maxlength=tail;
		
		return maxlength;
		
        
    }
	
	
}