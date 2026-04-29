class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int mx = 0, n = prices.length;
        for(int i = n-1; i>=0;i--){
            if(mx - prices[i] > ans){
                ans = mx - prices[i];
            }
            mx = Math.max(mx, prices[i]);
        }
        return ans;
    }
}
