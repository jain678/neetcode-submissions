class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i< n; i++){
            for(int j = 0;j <m ;j++){
                if(grid[i][j] == 2) q.add(new int []{i,j});
                else if(grid[i][j] == 1) fresh++;
            }
        }
        if(fresh == 0 && q.size() == 0) return 0; 
        if(q.size() == 0) return -1;


        int lvl = -1;
        int [][] dir = {{-1,0}, {0,-1}, {0,1}, {1,0}};
        while(!q.isEmpty()){
            lvl++;
            int size = q.size();
            for(int i = 0 ;i< size; i++){
                int [] t = q.poll();

                for(int j = 0; j<4; j++){
                    int x =t[0] + dir[j][0];
                    int y = t[1] + dir[j][1];

                    if(x>=0 && x < n && y>=0 && y<m && grid[x][y] == 1){
                        q.add(new int []{x,y});
                        grid[x][y] = 2;
                        fresh--;
                    }
                }
            }
        }

        return fresh == 0 ? lvl : -1;

    }
}
