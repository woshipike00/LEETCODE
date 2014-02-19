/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.


从两头开始扫描
*/

public class Solution {
    public int maxArea(int[] height) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		int i=0,j=height.length-1;
		int max=0;
		if(height.length<=1)
			return 0;
		while(i!=j){
			int area=min(height[i],height[j])*(j-i);
			if(area>max)
				max=area;
			if(height[i]>height[j])
				j--;
			else
				i++;
		}
		return max;
		
        
    }
	
	public int min(int x,int y){
		if(x>=y)
			return y;
		return x;
	}
}