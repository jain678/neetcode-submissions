class Solution {
    private void bfs(Queue<int[]> q , int [][] heights, boolean[][] visited, int n, int m){
        int [][] dir = {{-1,0}, {0,-1}, {0,1}, {1,0}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i< size; i++){
                int [] t = q.poll();
                visited[t[0]][t[1]] = true;
                for(int j = 0; j< 4; j++){
                    int x = t[0] + dir[j][0];
                    int y = t[1] + dir[j][1];

                    if(x>=0 && x<n && y>=0 && y< m && !visited[x][y] && heights[x][y] >= heights[t[0]][t[1]]){
                        q.add(new int[]{x,y});
                        // visited[x][y] = true;
                    }
                }
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        boolean [][] pac = new boolean[n][m];
        boolean [][] atl = new boolean[n][m];

        Queue<int[]> pacQueue = new LinkedList<>();
        Queue<int[]> atlQueue = new LinkedList<>();

        for(int i = 0; i< m; i++){
            pacQueue.add(new int[]{0, i});
            atlQueue.add(new int []{n-1, i});
        }
        for(int i = 0; i< n; i++){
            pacQueue.add(new int[]{i, 0});
            atlQueue.add(new int []{i, m-1});
        }
        bfs(pacQueue, heights, pac, n,m);
        bfs(atlQueue, heights, atl, n, m);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i< n; i++){
            for(int j= 0; j< m;j++){
                if(pac[i][j] == true && atl[i][j] == true){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;

    }
}
