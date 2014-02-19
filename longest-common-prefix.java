/*
Write a function to find the longest common prefix string amongst an array of strings.
*/

public class Solution {
   public String longestCommonPrefix(String[] strs) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(strs.length==0)
        	return "";
        if(strs.length==1)
            return strs[0];
        String result="";
        int j=0;
        while(true){ 	
        	int i;
        	for (i=0;i<strs.length;i++){
        		if(strs[i].length()==0)
        			return "";
        		if(j<strs[i].length() && strs[i].charAt(j)==strs[0].charAt(j))
        			continue;
        		else
        			break;
        	}
        	if(i!=strs.length)
        		break;
        	result+=strs[0].charAt(j);
        	j++;
        }
        return result;
    }
}