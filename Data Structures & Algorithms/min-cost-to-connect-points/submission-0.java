class DSU {
    int [] parent, size;
    DSU (int n){
        parent = new int [n+1];
        size = new int[n+1];
        for(int i = 0 ; i<=n; i++){
            parent[i] = i;
        }
        Arrays.fill(size ,1);
    }

    public int findPar(int node){
        if(parent[node] == node){
            return node;
        }
        return parent[node] = findPar(parent[node]);
    }

    public boolean union(int u, int v){
        int par_u = findPar(u);
        int par_v = findPar(v);

        if(par_u == par_v) return false;

        if(size[par_u] < size[par_v]){
            parent[par_u] = par_v;
            size[par_v] += size[par_u];
        }
        else {
            parent[par_v]  = par_u;
            size[par_u] += size[par_v];
        }
        return true;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        DSU dsu = new DSU(n);
        List<int[]> edges = new ArrayList<>();
        for(int i = 0 ; i< n; i++){
            for(int j = i+1; j<n; j++){
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int [] {dist, i, j});
            }
        }
        int ans = 0;
        edges.sort((a,b) -> a[0] - b[0]);
        for(int i = 0; i<edges.size(); i++){
            if(dsu.union(edges.get(i)[1] , edges.get(i)[2])){
                
                ans += edges.get(i)[0];
            }
        }
        return ans;
    }
}
