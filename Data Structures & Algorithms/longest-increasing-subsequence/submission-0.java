class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans = 1;
        int [] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int n = nums.length;
        for(int i = 0 ; i< n; i++){
            for(int j = 0; j<i; j++){
                if(nums[i] > nums[j])
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            System.out.print(dp[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
