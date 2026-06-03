class Solution {
    private int solve(int i, int j, int n, int m, int [][] grid){
        int cnt = 0;
        int [][] dir = {{-1,0}, {0,-1}, {0,1}, {1,0}};
        grid[i][j] = -1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int []{i,j});
        while(!q.isEmpty()){
            int [] t = q.poll();
            cnt++;
            for(int k = 0; k< 4; k++){
                int x = t[0] + dir[k][0];
                int y = t[1] + dir[k][1];

                if(x>=0 && x<n && y>=0 && y<m && grid[x][y] == 1){
                    q.offer(new int []{x,y});
                    grid[x][y] = -1;
                }
            }
        }
        return cnt;

    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int i = 0; i< n; i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == -1){
                    continue;
                }
                else if(grid[i][j] != -1 && grid[i][j] == 1){
                    ans = Math.max(ans, solve(i,j,n,m, grid));
                }
            }
        }
        return ans;
    }
}
