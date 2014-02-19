/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

判断当前的rating是连续递减的，还是转折点，还是递增，考虑收尾情况和rating相等的情况

*/

public class Solution {
    	public int candy(int[] ratings) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		if(ratings.length==1)
            return 1;
		
        int pos=0;
        int[] count=new int[ratings.length];
        for (int i=0;i<ratings.length;i++){
        	if(i==0 && ratings[0]<=ratings[1]){
        		count[0]=1;
        		pos++;
        		continue;
        	}
        	if(i==ratings.length-1){
        		if (pos==i){
        			if(ratings[i]>ratings[i-1])
        				count[i]=count[i-1]+1;
        			else {
        				count[i]=1;
					}
        		}
        		else {
        			int k=0;
            		for (;i-k>pos;k++){
                		count[i-k]=k+1;
                	}
            		if(k+1>count[i-k])
            			count[i-k]=k+1;
				}
        		break;
        	}

        	if(ratings[i]>ratings[i+1]){
        		if(i!=0){
        			if(ratings[i]==ratings[i-1])
        				count[i]=1;
        			else
        				count[i]=count[i-1]+1;
        		}
        		continue;

        	}
        	else if(ratings[i]<ratings[i-1]){
        		int k=0;
        		for (;i-k>pos;k++){
            		count[i-k]=k+1;
            	}
        		if(k+1>count[i-k])
        			count[i-k]=k+1;
            	pos=i+1;
        	}
        	else {
				if(ratings[i]>ratings[i-1])
					count[i]=count[i-1]+1;
				else
					count[i]=1;
				pos++;
			}
        	
        }
        
        
        int result=0;
        for (int i=0;i<count.length;i++){
        	result+=count[i];
        }
        
        return result;
    }
	
}