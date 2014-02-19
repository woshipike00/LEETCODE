/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        int length=s.length();
        boolean[] flags=new boolean[length];
        for (int i=0;i<length;i++){
            flags[i]=false;
            if(dict.contains(s.substring(0, i+1))){
                flags[i]=true;
                continue;
            }
            
            for (int j=0;j<i;j++){
                if(flags[j] && dict.contains(s.substring(j+1, i+1))){
                    flags[i]=true;
                    break;
                }
            }
            
        }
        return flags[length-1];
        
    }
}







/*Reference the dicussion in leetcode.

Here we use seg(i, j) to demonstrate whether substring start from i and length is j is in dict?

base case:

when j = 0; seg(i, j) = false;

State transform equation:

seg(i, j) = true. if s.substring(i, j - 1) is in dict.

else seg(i, j) = seg(i, k) && seg(i + k, j - k);

public class Solution {
	
    public boolean wordBreak(String s, Set<String> dict) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(s.length()==0 || dict.size()==0){
            return false;
        }

        boolean[][] flags=new boolean[s.length()][s.length()+1];
        for (int j=1;j<s.length()+1;j++){
            for (int i=0;i<=s.length()-j;i++){
                String temp=s.substring(i,i+j);
                if(dict.contains(temp)){
                    flags[i][j]=true;
                    continue;
                }
                int k;
                for (k=1;k<j;k++){
                    if(flags[i][k] && flags[i+k][j-k]){
                        System.out.println(i+","+k+","+j);
                        flags[i][j]=true;
                        break;
                    }
                }
                if(k==j)
                    flags[i][j]=false;


            }
        }

        
        return flags[0][s.length()];
        
    }


}*/
















