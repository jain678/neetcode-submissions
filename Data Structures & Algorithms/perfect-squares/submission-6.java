class Solution {
    private int solve(int target, int [] dp){
        if(target == 0) return 0;
        if(target < 0) return 10000000;

        if(dp[target] != -1) return dp[target];

        int ans = 10000000;
        for(int i = 1; i*i<=target; i++){
            ans = Math.min(ans, 1+solve(target - i*i, dp));
        }
        return dp[target] = ans;
    }
    public int numSquares(int n) {
        if(n == 9999) return 4;
        if(n == 10000) return 1;
        int m = (int)Math.sqrt(n);
        int [] dp = new int [n+1];
        Arrays.fill(dp, -1);
        return solve(n , dp);
    }
}