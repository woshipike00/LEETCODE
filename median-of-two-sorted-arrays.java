
/*
There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

首先假设数组A和B的元素个数都大于k/2，我们比较A[k/2-1]和B[k/2-1]两个元素，
这两个元素分别表示A的第k/2小的元素和B的第k/2小的元素。
这两个元素比较共有三种情况：>、<和=。如果A[k/2-1]<B[k/2-1]，这表示A[0]到A[k/2-1]的元素都在A和B合并之后的前k小的元素中。
换句话说，A[k/2-1]不可能大于两数组合并之后的第k小值，所以我们可以将其抛弃。

当A[k/2-1]>B[k/2-1]时存在类似的结论。

当A[k/2-1]=B[k/2-1]时，我们已经找到了第k小的数，也即这个相等的元素，我们将其记为m。由于在A和B中分别有k/2-1个元素小于m，所以m即是第k小的数。

通过上面的分析，我们即可以采用递归的方式实现寻找第k小的数。此外我们还需要考虑几个边界条件：

如果A或者B为空，则直接返回B[k-1]或者A[k-1]；
如果k为1，我们只需要返回A[0]和B[0]中的较小值；
如果A[k/2-1]=B[k/2-1]，返回其中一个；
*/



public class Solution {
	
	
	public double findMedianSortedArrays(int A[], int B[]) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case
			
		int total=A.length+B.length;
		if(total %2 == 0)
			return ((double)findKth(A, 0, B, 0, total/2)+(double)findKth(A, 0, B, 0, total/2+1))/2;
		else
			return (double)findKth(A, 0, B, 0, total/2+1);
        
    }
	
	public int findKth(int[] a,int starta,int[] b,int startb,int k){
		int m=a.length-starta;
		int n=b.length-startb;
		//ensure m is smaller than n
		if(m>=n)
			return findKth(b, startb, a, starta, k);
		else if(m==0)
			return b[k+startb-1];
		else if(k==1)
			return min(a[starta],b[startb]);
		else {
			int p=min(k/2,m);
			if(a[starta+p-1]>b[startb+k-p-1])
				return findKth(a, starta, b, startb+k-p, p);
			else if (a[starta+p-1]<b[startb+k-p-1])
				return findKth(a, starta+p, b, startb, k-p);
			else
				return a[starta+p-1];
		}
		
		
			
	}
	
	public int min(int a,int b){
		if(a>b)
			return b;
		else
			return a;
	}
	
	
	

    public static void main(String[] args){
    	Solution solution=new Solution();
    	int[] a={1,2,3,4};
    	int[] b={2,3,4,5};
    	System.out.println(solution.findKth(a, 0, b, 0, 4));
    	
    }


}
