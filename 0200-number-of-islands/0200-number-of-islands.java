class Solution {
    int n;
    int m;
    int[] dr = {-1,0,1,0};
    int[] dc = {0,1,0,-1};
    public void BFS(int row , int col,char[][]grid,boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row,col});
        visited[row][col] = true;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for(int i=0;i<4;i++){
                int newRow = r+dr[i];
                int newCol = c+dc[i];
                if(newRow>=0 && newRow<n
                && newCol>=0 && newCol<m
                && grid[newRow][newCol]=='1'
                && visited[newRow][newCol]==false){
                    q.offer(new int[]{newRow,newCol});
                    visited[newRow][newCol]=true;
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        n= grid.length;
        m = grid[0].length;
        boolean[][] visited = new boolean[n+1][m+1];
        int component =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==false){
                    if(grid[i][j]=='1'){
                        BFS(i,j,grid,visited);{
                            component++;
                        }
                    }
                }
            }
        }
        return component;
    }
}