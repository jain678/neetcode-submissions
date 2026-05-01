class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(
                (b[0]*b[0] + b[1]*b[1]),
                (a[0]*a[0] + a[1]*a[1])
            )
        );
        for(int i = 0 ; i< points.length; i++){
            if(pq.size() < k){
                pq.add(points[i]);
            }
            else{
                int dist1 =  (points[i][0]*points[i][0] + points[i][1]*points[i][1]);
                int [] temp = pq.peek();
                int dist2 = (temp[0]*temp[0] + temp[1]*temp[1]);
                if(dist1 < dist2){
                    pq.poll();
                    pq.add(points[i]);
                }
            }
        }
        int [][] ans = new int[k][2];
        int i = 0;
        while(!pq.isEmpty() && i < k){
            ans[i] = pq.poll();
            i++;
        }
        return ans;
    }
}
