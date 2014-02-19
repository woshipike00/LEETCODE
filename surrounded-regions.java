/*
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region .

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X


这题dfs递归调用太多，会stackoverflow，bfs可以

*/




public class Solution {
    private int m,n;
	private char[][] board;
	private Queue<Integer> queue=new LinkedList<Integer>();
	
	public void solve(char[][] board) {
		if(board==null)
			return;
		m=board.length;
		if (m==0)
			return;
	    n=board[0].length;
		if (n==0)
		    return;
		
		this.board=board;
		for (int i=0;i<m;i++){
			bfs(i, 0);
			bfs(i, n-1);
			
		}
		
		for (int j=0;j<n;j++){
			bfs(0, j);
			bfs(m-1, j);
			
		}
		
		for (int i=0;i<m;i++){
			for (int j=0;j<n;j++){
				if(board[i][j]=='#')
					board[i][j]='O';
				else if(board[i][j]=='O')
					board[i][j]='X';
			}
				
		}
		
		
	        
	        
	}
	
	
	public void bfs(int i,int j){
		if(!fill(i, j))
			return;
		while(!queue.isEmpty()){
			int temp=queue.poll();
			int nn=temp%n;
			int mm=(temp-nn)/n;
			fill(mm+1, nn);
			fill(mm-1, nn);
			fill(mm, nn+1);
			fill(mm, nn-1);
		}
	}
	
	public boolean fill(int i,int j){
		if (i<0 || i>m-1 || j<0 || j>n-1 || board[i][j]!='O')
			return false;
		board[i][j]='#';
		queue.add(i*n+j);
		return true;
	}

	
}



==========================================================================


private int m,n;
	
	public void solve(char[][] board) {
		if(board==null)
			return;
		m=board.length;
		if (m==0)
			return;
	    n=board[0].length;
		if (n==0)
		    return;
		
		
		//将四条边的O按dfs遍历
		for (int i=1;i<m-1;i++){
			if (board[i][0]=='O')
				dfs(board,  i, 0);
			if (board[i][n-1]=='O')
				dfs(board, i, n-1);
		}
		
		for (int j=1;j<n-1;j++){
			if (board[0][j]=='O')

				dfs(board, 0, j);
			if (board[m-1][j]=='O')

				dfs(board, m-1, j);
		}
		
		for (int i=0;i<m;i++){
			for (int j=0;j<n;j++){
				if(board[i][j]=='#')
					board[i][j]='O';
				if(board[i][j]=='O')
					board[i][j]='X';
			}
				
		}
	        
	        
	}
	
	public void dfs (char[][] board,int i,int j){
		if (i<0 || i>m-1 || j<0 || j>n-1 || board[i][j]!='O')
			return;
		board[i][j]='#';
		
		if (i-1 >=0 && board[i-1][j]=='O' )

			dfs(board, i-1, j);
		if (j-1>=0 && board[i][j-1]=='O')

			dfs(board, i, j-1);
		if (i+1<m && board[i+1][j]=='O')

			dfs(board, i+1, j);
		if (j+1<n && board[i][j+1]=='O')

			dfs(board, i, j+1);
		
			
	}