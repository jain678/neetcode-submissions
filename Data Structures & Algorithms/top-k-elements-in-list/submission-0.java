class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        
        Map<Integer,Integer> m = new HashMap<>();
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> m.get(a) - m.get(b));
        for(int num : m.keySet()){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int [] ans = new int [k];
        for (int i = k-1; i>=0; i--){
            ans[i] = pq.poll();
        }
        return ans;
    }
}
