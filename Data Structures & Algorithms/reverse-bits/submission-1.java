class Solution {
    public int reverseBits(int n) {
        long ans = 0;
        int cnt = 0;
        for(int i = 0; i< 32; i++){
            if((n&1) == 1){
                ans += (long)Math.pow(2, 31- cnt);
                // System.out.println(cnt);
            }
            n = n>>1;
            System.out.println(cnt);
            cnt++;
        }
        return (int)ans;
    }
}
