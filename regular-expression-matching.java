/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/

public class Solution {
   public boolean isMatch(String s, String p) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		if(s.length()==0 && p.length()==0)
			return true;
		if(s.length()!=0 && p.length()==0)
			return false;
		if(s.length()==0){
			if(p.length()>=2 && p.charAt(1)=='*')
				return isMatch(s, subString(p, 2));
			return false;
		}
	
		int starts=0,startp=0;
		
		if(startp+1>=p.length()){
			return s.length()==1 &&( p.charAt(startp)=='.' || p.charAt(startp)==s.charAt(starts));
		}
		
		if(p.charAt(startp+1)!='*'){
			
			return (p.charAt(startp)==s.charAt(starts) || p.charAt(startp)=='.') && isMatch(subString(s,starts+1), subString(p,startp+1));
			
		}
		
		else {
			while(s.charAt(starts)==p.charAt(startp) || (p.charAt(startp)=='.' && starts<s.length())){
				if(isMatch(subString(s,starts), subString(p,startp+2)))
					return true;
				starts++;
				if(starts>=s.length())
					break;
			}
		}
		return isMatch(subString(s,starts), subString(p,startp+2));
        
    }
	
	public String subString(String s,int start){
		if(start>=s.length())
			return "";
		return s.substring(start);
	}
	
}