
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] ans = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i,j,0});
                    visited[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];
            ans[r][c] = d;
            for(int[] x:dir){
                int newRow = r+x[0];
                int newColumn = c+x[1];
                if(newRow>=0
                && newColumn>=0
                && newRow<m
                && newColumn<n
                && !visited[newRow][newColumn]){
                    visited[newRow][newColumn] = true;
                    q.offer(new int[]{newRow,newColumn,d+1});
                }
            }
        }
        return ans;
    }
}
