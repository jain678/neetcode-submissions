class Solution {
    private void dfs(List<Integer>[] adj, int i, boolean[] visited){
        visited[i] = true;
        for(int u : adj[i]){
            if(!visited[u]){
                dfs(adj, u, visited);
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        boolean [] visited = new boolean[n];
        List<Integer>[] adj = new ArrayList[n];

        for(int i = 0 ; i< n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0 ; i< edges.length; i++){
            int a= edges[i][0];
            int b = edges[i][1];

            adj[a].add(b);
            adj[b].add(a);
        }
        int cnt = 0;
        for(int i = 0 ;i< n; i++){
            if(!visited[i]){
                dfs(adj, i, visited);
                cnt++;
            }
        }
        return cnt;
    }
}
