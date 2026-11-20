class Solution {
    int n;
    int m;
    int[] dr = {-1,0,1,0};
    int[] dc = {0,1,0,-1};
    public int BFS(int row , int col,int[][]grid,boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row,col});
        visited[row][col] = true;
        int area =1;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for(int i=0;i<4;i++){
                int newRow = r+dr[i];
                int newCol = c+dc[i];
                if(newRow>=0 && newRow<n
                && newCol>=0 && newCol<m
                && grid[newRow][newCol]==1
                && visited[newRow][newCol]==false){
                    q.offer(new int[]{newRow,newCol});
                    visited[newRow][newCol]=true;
                    area++;
                }
            }
        }
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        n= grid.length;
        m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int maxArea =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==false){
                    if(grid[i][j]==1){
                        maxArea = Math.max(maxArea, BFS(i, j, grid, visited));
                    }
                }
            }
        }
        return maxArea;
    }
}