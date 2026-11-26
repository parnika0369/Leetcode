class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> q= new LinkedList<>();
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        q.offer(new int[]{entrance[0],entrance[1],0});
        maze[entrance[0]][entrance[1]] ='+';
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int r = curr[0];
            int c = curr[1];
            int steps = curr[2];
            for(int[] x:dir){
                int nr = r+x[0];
                int nc = c+x[1];
                if(nr >= 0 && nc >= 0 && nr < m && nc < n
                   && maze[nr][nc] == '.'){
                    if(nr==0||nc==0||nr==m-1||nc==n-1){
                        return steps+1;
                    }
                    maze[nr][nc] = '+';
                    q.offer(new int[]{nr, nc, steps + 1});
                    
                }
                
            }
        }
        return -1;
    }
}