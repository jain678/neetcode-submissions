class Solution {
    private void solve(int i, int j,int n, int m, int [][] visited, char [][] grid){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        visited[i][j] = 1;
        int [][] adj = {{-1,0},{0,-1},{1,0},{0,1}};
        while (!q.isEmpty()) {

            int[] cur = q.poll();

            for (int k = 0; k < 4; k++) {

                int x = cur[0] + adj[k][0];
                int y = cur[1] + adj[k][1];

                if (x >= 0 && x < n &&
                    y >= 0 && y < m &&
                    visited[x][y] == 0 &&
                    grid[x][y] == '1') {

                    visited[x][y] = 1;
                    q.offer(new int[]{x, y});
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] visited = new int[n][m];
        int cnt = 0;
        for(int i = 0 ; i< n; i++){
            for(int j = 0 ; j < m; j++){
                if(visited[i][j] == 1){
                    continue;
                }
                else if(visited[i][j] == 0 && grid[i][j] == '1'){
                    cnt++;
                    solve(i,j,n,m,visited, grid);
                }
            }
        }
        return cnt;
    }
}
