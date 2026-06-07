class DSU{
    private int [] parent;
    public DSU(int size){
        parent = new int [size];
        for(int i = 0; i< size; i++){
            parent[i] = i;
        }
    }

    public int findPar(int i){
        if(parent[i] == i) return i;

        return parent[i] = findPar(parent[i]);
    }

    public boolean union(int u, int v){
        int par_u = findPar(u);
        int par_v = findPar(v);

        if(par_u == par_v){
            return false;
        }
        parent[par_u] = par_v;
        return true;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n+1);
        for(int i = 0; i< n; i++){
            int a= edges[i][0];
            int b = edges[i][1];
            if(!dsu.union(a,b)){
                return edges[i];
            }
        }
        return new int[]{};
    }
}
