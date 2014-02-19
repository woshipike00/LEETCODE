/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public boolean isValid(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> list1=new ArrayList<Integer>();
        ArrayList<Integer> list2=new ArrayList<Integer>();
        ArrayList<Integer> list3=new ArrayList<Integer>();
        for(int i=0;i<s.length();i++){
        	if(s.charAt(i)=='(')
        		list1.add(i);
        	if(s.charAt(i)=='[')
        		list2.add(i);
        	if(s.charAt(i)=='{')
        		list3.add(i);
        	if(s.charAt(i)==')'){
        		if(list1.size()==0)
        			return false;
        		int temp=list1.get(list1.size()-1);
        		if(list2.size()>0 && list2.get(list2.size()-1)>temp || list3.size()>0 && list3.get(list3.size()-1)>temp)
        			return false;
        		list1.remove(list1.size()-1);
        	}
        	if(s.charAt(i)==']'){
        		if(list2.size()==0)
        			return false;
        		int temp=list2.get(list2.size()-1);
        		if(list1.size()>0 && list1.get(list1.size()-1)>temp || list3.size()>0 && list3.get(list3.size()-1)>temp)
        			return false;
        		list2.remove(list2.size()-1);
        	}
        	if(s.charAt(i)=='}'){
        		if(list3.size()==0)
        			return false;
        		int temp=list3.get(list3.size()-1);
        		if(list1.size()>0 && list1.get(list1.size()-1)>temp || list2.size()>0 && list2.get(list2.size()-1)>temp)
        			return false;
        		list3.remove(list3.size()-1);
        	}
        }
        if(list1.size()==0 && list2.size()==0 && list3.size()==0)
        	return true;
        return false;
        
    }