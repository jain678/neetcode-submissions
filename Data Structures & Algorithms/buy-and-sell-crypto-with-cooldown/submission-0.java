class Solution {

    private int solve(int [] prices,int i, int n, int buy, int [][] dp){
        if(i >= n) return 0;
        if(dp[i][buy] != -1) return dp[i][buy];
        if(buy == 1){
            return dp[i][buy] =  Math.max(solve(prices, i+1, n, 0, dp) - prices[i], solve(prices, i+1, n, buy, dp));
        }
        else{
            return dp[i][buy] = Math.max(solve(prices, i+2, n, 1, dp) + prices[i], solve(prices, i+1, n, buy, dp));
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][] dp = new int [n][2];
        for(int i = 0; i< n; i++){
            dp[i][0]= -1;
            dp[i][1] = -1;
        }
        return solve(prices,0,n, 1, dp);
    }
}
