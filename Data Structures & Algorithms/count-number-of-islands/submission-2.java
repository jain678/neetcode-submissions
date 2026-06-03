class Solution {
    private void solve(int i, int j,int n, int m, char [][] grid){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        grid[i][j] = '2';
        int [][] adj = {{-1,0},{0,-1},{1,0},{0,1}};
        while (!q.isEmpty()) {

            int[] cur = q.poll();

            for (int k = 0; k < 4; k++) {

                int x = cur[0] + adj[k][0];
                int y = cur[1] + adj[k][1];

                if (x >= 0 && x < n &&
                    y >= 0 && y < m &&
                    grid[x][y] != '2' &&
                    grid[x][y] == '1') {

                    grid[x][y] = '2';
                    q.offer(new int[]{x, y});
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        for(int i = 0 ; i< n; i++){
            for(int j = 0 ; j < m; j++){
                if(grid[i][j] == '2'){
                    continue;
                }
                else if(grid[i][j] != '2' && grid[i][j] == '1'){
                    cnt++;
                    solve(i,j,n,m, grid);
                }
            }
        }
        return cnt;
    }
}
