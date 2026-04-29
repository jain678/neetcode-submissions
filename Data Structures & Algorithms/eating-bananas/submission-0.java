class Solution {
    private int canEatAll(int [] piles, int m){
        int hr = 0;
        for(int i = 0; i < piles.length; i++){
            if(piles[i] <= m){
                hr++;
            }
            else {
                hr = piles[i]%m == 0? hr + piles[i]/m : hr + piles[i]/m + 1;
            }
        }
        return hr;
    }
    public int minEatingSpeed(int[] piles, int n) {
        int l = 1, h = 1000000000;
        int ans = 0;
        while(l < h){
            int m = (l + h)/2;
            int hour = canEatAll(piles,  m);
            System.out.println(hour);
            
            if(hour <= n){
                ans = m;
                h = m;
            }
            else{
                l = m+1;
            }
        }
        return ans;
    }
}
