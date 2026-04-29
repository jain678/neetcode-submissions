class Solution {
    public int[] countBits(int n) {
        int [] ans = new int [n+1];
        for(int i = 0 ; i<= n; i++){
            int cnt = 0;
            int j = i;
            while(j > 0){
                if((j& 1) == 1){
                    cnt++;
                }
                j = j>>1;
            }
            ans[i] = cnt;
        }
        return ans;
    }
}
