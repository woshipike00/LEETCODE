/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

public int threeSumClosest(int[] num, int target) {
        if(num.length==3)
        	return num[0]+num[1]+num[2];
        
        Arrays.sort(num);
        
        boolean flag=false;
        int s=0;
        int result=0;
        
        for (int i=0;i<num.length-2;i++){
        	if(i>0 && num[i]==num[i-1])
        		continue;
        	for (int m=i+1,n=num.length-1;m<n;){
        		if(m>i+1 && num[m]==num[m-1]){
        			m++;
        			continue;
        		}
        		if(n<num.length-1 && num[n]==num[n+1]){
        			n--;
        			continue;
        		}
        		
        		if(!flag){
        			s=Math.abs(num[i]+num[m]+num[n]-target);
        			result=num[i]+num[m]+num[n];
        			flag=true;
        		}
        		if (Math.abs(num[i]+num[m]+num[n]-target)<s){
        			s=Math.abs(num[i]+num[m]+num[n]-target);
        			result=num[i]+num[m]+num[n];
        		}
        		if(num[i]+num[m]+num[n]<target)
        			m++;
        		else 
					n--;        			
        			
        	}
        }
        
        return result;
    }