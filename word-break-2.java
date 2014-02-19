/*
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/


public class Solution {
    
    public boolean judge(String s, Set<String> dict) {
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
    
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(!judge(s,dict))
            return new ArrayList<String>();
        
        int length=s.length();
        boolean[] flags=new boolean[length];
        ArrayList[] caches=new ArrayList[length];
        
        for (int i=0;i<length;i++){
        	flags[i]=false;
        	caches[i]=new ArrayList<String>();
        	
        	if(dict.contains(s.substring(0, i+1))){
        		flags[i]=true;
        		caches[i].add(new String(s.substring(0, i+1)));
        		
        	}
        	
        	for (int j=0;j<i;j++){
        		if(flags[j] && dict.contains(s.substring(j+1, i+1))){
        			flags[i]=true;
        			for(int k=0;k<caches[j].size();k++){
        				String newstring=caches[j].get(k).toString().concat(" "+s.substring(j+1, i+1));
        				caches[i].add(newstring);
        			}
        			
        		}
        	}
        	//System.out.println(caches[i]);
        	
        }
        return caches[length-1];
    }
}