class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int n : nums){
            st.add(n);
        }
        int ans = 0;
        for(int n : nums){
            int cnt = 0;
            int m = n;
            if(st.contains(m-1)){
                continue;
            }
            while(st.contains(m)){
                cnt++;
                m++;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
