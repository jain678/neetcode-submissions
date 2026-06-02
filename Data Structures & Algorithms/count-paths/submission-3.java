class Solution {
    public int uniquePaths(int m, int n) {
        int ans = 0;
        if(m ==1 || n ==1 ) return 1;
        int [] dp = new int [n];
        Arrays.fill(dp,1);
        int sum;
        for(int i = 1; i<m; i++){
            sum = 1;
            for(int j = 1; j< n; j++){
                int x = sum + dp[j];
                sum = x;
                dp[j] = x;
            }
        }
        
        return dp[n-1];
    }
}
