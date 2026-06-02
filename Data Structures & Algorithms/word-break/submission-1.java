class Solution {
    private boolean solve(int i, int n, String s,List<String> wordDict, Boolean [] dp){
        if(i == n){
            return true;
        }
        if(dp[i] != null){
            return dp[i];
        }
        for(String w : wordDict){
            if(i + w.length() <= n && s.substring(i, i + w.length()).equals(w)){
                if(solve(i + w.length(), n, s, wordDict, dp)){
                    dp[i] = true;
                    return true;
                }
            }
        }
        dp[i] = false;
        return false;

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean [] dp = new Boolean[s.length()];
        return solve(0, s.length(), s, wordDict, dp);
    }
}
