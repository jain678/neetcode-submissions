class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] inorder = new int[numCourses];
        boolean [] visited = new boolean[numCourses];   
        int n = prerequisites.length;
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0 ; i< n; i++){
            inorder[prerequisites[i][0]]++;
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i< numCourses; i++){
            if(inorder[i] == 0) q.add(i);
        }
        if(q.isEmpty()) return false;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i< size; i++){
                int t = q.poll();
                visited[t] = true;
                for(int u : adj[t]){
                    inorder[u]--;
                    if(inorder[u] == 0 && !visited[u]){
                        q.add(u);
                    }
                }
            }
        }   
        for(int i = 0 ; i< numCourses; i++){
            if(!visited[i] ){
                return false;
            }
        }
        return true;
        
    }
}
