class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adj = new ArrayList[n+1];
        int [] dist = new int[n+1];
        for(int i = 0 ;i<=n; i++){
            adj[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        for(int i =0; i< times.length; i++){
            int a = times[i][0];
            int b = times[i][1];
            int t = times[i][2];

            adj[a].add(new int[]{b,t});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[1] < b[1]) return -1;
            if(a[1] > b[1]) return 1;
            return 0;
        });
        pq.add(new int []{k,0});
        dist[k] = 0;
        while(!pq.isEmpty()){
            int [] t = pq.poll();
            int node = t[0];
            int time = t[1];

            if(time > dist[node]) continue;
            for(int [] u : adj[node]){
                int nei = u[0];
                int wt = u[1];
                if(dist[node] + wt < dist[nei]){
                    dist[nei] = dist[node] + wt;
                    pq.add(new int[]{nei, dist[nei]});
                }
            }
        }
        int ans = 0;
        for(int i = 1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            else {
                ans = Math.max( dist[i], ans);
            }
            System.out.print(dist[i]);
        }
        return ans;
    }
}
