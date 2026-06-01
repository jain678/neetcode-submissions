class Solution {
    private int solve(int i, int n, String s, int [] dp){
        if(i == n) return 1;
        if(s.charAt(i) == '0') return 0;
        if(dp[i] != -1) return dp[i];
        int ways = solve(i+1, n, s , dp);
        if(i+1 < n){
            int num = (s.charAt(i) - '0')*10 + (s.charAt(i+1) - '0');

            if(num >= 10 && num <= 26)
                ways += solve(i+2, n, s, dp);
        }
        return dp[i] = ways;
        
    }
    public int numDecodings(String s) {
        int len = s.length();
        int [] dp = new int[len];
        Arrays.fill(dp, -1);
        return solve(0, len, s, dp);
    }
}
