class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q= new LinkedList<>();
        int count = 0;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0&&!visited[i][j]){
                    boolean closed = true;
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        int r = curr[0];
                        int c = curr[1];
                        if(r==0||c==0||r==m-1||c==n-1){
                            closed = false;
                        }
                        for(int[] x : dir){
                            int newRow = r+x[0];
                            int newColumn = c+x[1];
                            if(newRow>=0
                            && newColumn>=0
                            && newRow<m
                            && newColumn<n
                            && grid[newRow][newColumn] == 0
                            && !visited[newRow][newColumn]){
                                visited[newRow][newColumn] = true;
                                q.offer(new int[]{newRow,newColumn});
                            }
                        }

                    }
                    if(closed){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}