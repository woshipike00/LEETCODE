/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		if(num.length<3)
		    return result;
		Arrays.sort(num);

		if(num.length==3)
			if(num[0]+num[1]+num[2]==0){
				ArrayList<Integer> arrayList=new ArrayList<Integer>();
				arrayList.add(num[0]);
				arrayList.add(num[1]);
				arrayList.add(num[2]);
				result.add(arrayList);
				return result;
			}
			else
				return result;
		
		
		
		for (int i=0;i<num.length-2;i++){
			int a=num[i];
			if(i>=1 && num[i]==num[i-1])
				continue;
			for (int m=i+1,n=num.length-1;m<n;){
				if(m>=i+2 && num[m]==num[m-1]){
					m++;
					continue;
				}
				if(n<=num.length-2 && num[n]==num[n+1]){
					n--;
					continue;
				}
				if(num[m]+num[n]==-a){
					ArrayList<Integer> arrayList=new ArrayList<Integer>();
					arrayList.add(a);
					arrayList.add(num[m]);
					arrayList.add(num[n]);
					result.add(arrayList);
					m++;
					n--;
				}
				else if(num[m]+num[n]>0-a)
					n--;
				else
					m++;
			}
		}
		return result;
    }
}