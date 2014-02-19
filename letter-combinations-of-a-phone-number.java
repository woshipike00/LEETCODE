/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/

public class Solution {
    private Map<String, String> map=new HashMap<String, String>();
	
	public ArrayList<String> letterCombinations(String digits) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		initmap();
		ArrayList<String> result=new ArrayList<String>();
		if(digits.length()==0){
		    result.add("");
		    return result;
		}
		    
		cal(digits, 0, "", result);
        return result;
    }
	
	public void cal(String digits,int pos,String temp,ArrayList<String> result){
		String mapString=map.get(String.valueOf(digits.charAt(pos)));
		for (int i=0;i<mapString.length();i++){
			String newtemp=temp+mapString.charAt(i);
			if(pos==digits.length()-1)
				result.add(newtemp);
			else
				cal(digits, pos+1, newtemp, result);
		}
	}
	
	public void initmap(){
		map.clear();		
		map.put("0", "");
		map.put("1", "");
		map.put("2", "abc");
		map.put("3", "def");
		map.put("4", "ghi");
		map.put("5", "jkl");
		map.put("6", "mno");
		map.put("7", "pqrs");
		map.put("8", "tuv");
		map.put("9", "wxyz");

	}
}