class KthLargest {

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int sz;

    public KthLargest(int k, int[] nums) {
        sz = k;
        for(int i = 0 ; i< nums.length; i++){
            if(pq.size() < sz){
                pq.add(nums[i]);
            }
            else{
                int a = pq.peek();
                if(nums[i] > a){
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
    }
    
    public int add(int val) {
        if(pq.isEmpty() || pq.size() < sz){
            pq.add(val);
        }
        else{
            if(pq.peek() < val){
                pq.poll();
                pq.add(val);
            }
        }
       
        return pq.peek();
    }
}
