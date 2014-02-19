
/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

Discuss


*/




public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        int[] result=new int[2];
        for (int i=0;i<numbers.length;i++){
        	if(map.containsKey(numbers[i])){
        		result[0]=map.get(numbers[i])+1;
        		result[1]=i+1;
        	}
        	map.put(target-numbers[i], i);
        }
        return result;
    }
}



/*
	public int[] twoSum(int[] numbers, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int i=0;
        int j=numbers.length-1;
        quicksort(numbers, 0, j);
        for (int k=0;k<numbers.length;k++)
        	System.out.println(numbers[k]+",");
        while(i!=j){
        	if(numbers[i]+numbers[j]==target)
        		break;
        	else if (numbers[i]+numbers[j]>target) {
				j--;
			}
        	else {
				i++;
			}
        }
        int[] temp={i+1,j+1};
        return temp;
    }
	
	public void quicksort(int[] numbers,int lo,int hi){
		if(lo>=hi)
			return;
		int privot=partition(numbers, lo, hi);
		
		quicksort(numbers, lo, privot-1);
		quicksort(numbers, privot+1, hi);
	}
	
	public int partition(int[] numbers,int lo,int hi){
		int p=numbers[lo];
		int a=lo+1;
		for (int b=a;b<=hi;b++){
			if(numbers[b]<=p){
				if(a==b){
					a++;
					continue;
				}
				int temp=numbers[b];
				numbers[b]=numbers[a];
				numbers[a]=temp;
				a++;
			}
		
		}
		int temp=numbers[a-1];
		numbers[a-1]=p;
		numbers[lo]=temp;
		return a-1;
	}
*/