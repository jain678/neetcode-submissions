class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        for(int i = 0; i< n; i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int [][] adj = {{-1,0}, {0,-1}, {0,1}, {1,0}};
        int lvl = 0;
        while(!q.isEmpty()){
            
            int size = q.size();
            for(int i = 0; i< size; i++){
                int [] t = q.poll();
                // grid[t[0]][t[1]] = lvl;
                for(int j = 0 ;j< 4; j++){
                    int x = t[0] + adj[j][0];
                    int y = t[1] + adj[j][1];
                    if(x >=0 && x<n && y>=0 && y<m && grid[x][y] > lvl){
                        q.offer(new int []{x,y});
                        grid[x][y] = lvl+1;
                    }
                }
                
            }
            lvl++;
        }
        return ;
    }
}
