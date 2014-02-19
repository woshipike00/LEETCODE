/**

Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Discuss




 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    private HashMap<Double, Integer> hashMap=new HashMap<Double, Integer>();
	private int vertical=1;
	private int superposition=0;
	
	public int maxPoints(Point[] points) {
		
		if(points.length==0 || points.length==1 || points.length==2)
			return points.length;
		
		int totalmax=0;
		
		for (int i=0;i<points.length-1;i++){
			hashMap.clear();
			vertical=1;
			superposition=0;

			//max为每次循环中的最大值
			int max=1;
			
			for (int j=i+1;j<points.length;j++){
				
				//两点重合
				if (points[j].x==points[i].x && points[j].y==points[i].y){
					superposition++;
					max++;
				}
						
				//两点垂直
				else if(points[j].x==points[i].x){
					vertical++;
					if(vertical+superposition>max)
						max=vertical+superposition;
				}
				
				//将斜率一致的存入hashmap
				else {
					double slope=0;
					slope=((double)(points[i].y-points[j].y))/((double)(points[i].x-points[j].x));
					if(slope==0){
						slope=0;
					}
					if(hashMap.containsKey(slope)){
						hashMap.put(slope, hashMap.get(slope)+1);
						
					}
					else {
						hashMap.put(slope, 2);
					}
					
					if(hashMap.get(slope)+superposition>max)
						max=hashMap.get(slope)+superposition;
				}
			}
			if(max>totalmax)
				totalmax=max;
		}
		return totalmax;
    }
}