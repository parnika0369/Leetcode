class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<m;i++){
            if(grid[i][0]==1&& !visited[i][0]){
                q.offer(new int[]{i,0});
                visited[i][0]= true;
            }
            if(grid[i][n-1]==1&& !visited[i][n-1]){
                q.offer(new int[]{i,n-1});
                visited[i][n-1]= true;
            }
        }
        for(int j=0;j<n;j++){
            if(grid[0][j]==1&& !visited[0][j]){
                q.offer(new int[]{0,j});
                visited[0][j]= true;
            }
            if(grid[m-1][j]==1&& !visited[m-1][j]){
                q.offer(new int[]{m-1,j});
                visited[m-1][j] = true;
            }
        }
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for(int[] x:dir){
                int newRow = r+x[0];
                int newColumn = c+x[1];
                if(newRow>=0
                && newColumn>=0
                && newRow<m
                && newColumn<n
                && grid[newRow][newColumn]==1
                && !visited[newRow][newColumn]){
                    visited[newRow][newColumn]=true;
                    q.offer(new int[]{newRow,newColumn});
                }
            }
        }
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1&& !visited[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
}