class Solution {
    public int[] findOrder(int num, int[][] pre) {
        int n = pre.length;
        List<Integer>[] adj = new ArrayList[num];
        boolean [] visited = new boolean[num];
        int [] inorder = new int[num];
        for(int i = 0 ; i< num; i++){
            adj[i] = new ArrayList<>();
        }
        Queue<Integer> q = new LinkedList<>();
        int [] ans = new int[num];
        for(int i = 0 ; i< n;i++){
            inorder[pre[i][0]]++;
            adj[pre[i][1]].add(pre[i][0]);
        }

        for(int i = 0 ; i< num; i++){
            if(inorder[i] == 0){
                q.add(i);
            }
        }
        if(q.size() == 0){
            return new int[]{};
        }
        int k = 0;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                int v = q.poll();
                ans[k++] = v;
                visited[v] = true;
                for(int u: adj[v]){
                    inorder[u]--;
                    if(inorder[u] == 0 && !visited[u]) q.add(u);
                }
            }
        }
        for(int i = 0 ; i< num; i++){
            if(!visited[i]) return new int []{};
        }
        return ans;
    }
}
