class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i< stones.length; i++){
            pq.add(stones[i]);
        }

        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            int c = Math.abs(a - b);
            if(c != 0)
            pq.add(c);
        }
        return pq.size() == 0 ? 0 : pq.peek();
    }
}
