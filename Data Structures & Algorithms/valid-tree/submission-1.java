class Solution {
    private boolean cycle(List<Integer>[] adj,int i, int n, boolean [] visited, int par){
        visited[i] = true;
        for(int u: adj[i]){
            if(par == u)  continue;
            if(!visited[u]){
                if(cycle(adj, u, n, visited, i)){
                    return true;
                }
            }
            else{
                return true;
            }
        }
        return false;
    }
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0 ; i< n; i++){
            adj[i] = (new ArrayList<>());
        }
         for(int i = 0 ; i< edges.length; i++){
            int a = edges[i][0], b = edges[i][1];
            adj[a].add(b);
            adj[b].add(a);
        }
        boolean [] visited = new boolean[n];
        boolean hasCycle = !cycle(adj,0, n, visited, -1);
        for(boolean i : visited){
            if(!i){
                return false;
            }
        }
        return hasCycle;
    }
}
