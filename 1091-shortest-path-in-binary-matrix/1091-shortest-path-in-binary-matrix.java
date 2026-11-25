class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        if(grid[0][0]==1 || grid[n-1][n-1]==1){
            return -1;
        }
        int[][] dir = {{-1,-1},{0,1},{0,-1},{1,-1},{-1,0},{1,0},{1,1},{-1,1}}; //direction
        q.offer(new int[]{0,0,1});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];
            if(r==n-1 && c==n-1){
                return d;
            }
            for(int[] x:dir){
                int newRow = r+x[0];
                int newColumn = c+x[1];
                if(newRow>=0 
                && newColumn>=0 
                && newRow <n 
                && newColumn<n 
                && grid[newRow][newColumn] == 0
                && !visited[newRow][newColumn]){
                    visited[newRow][newColumn] = true;
                    q.offer(new int[]{newRow,newColumn,d+1});
                }

            }
        }
        return -1;
    }
}