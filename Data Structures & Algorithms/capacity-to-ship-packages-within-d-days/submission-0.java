class Solution {
    private int solve(int [] arr, int days, int mid){
        int cnt = 1;
        int sum = 0;
        int i =0;
        while(i < arr.length){
            sum += arr[i];
            if(arr[i] > mid) return 100000000;
            if(sum > mid){
                cnt++;
                sum =0;
            }
            else{
                i++;
            }
        }
        System.out.println(mid);
        return cnt;
    }
    public int shipWithinDays(int[] weights, int days) {
        int l = 0, h = 1000000000;
        int ans = 1000000000;
        while(l < h){
            int mid = l + (h - l)/2;
            int res = solve(weights, days, mid);
            if(res <= days){
                ans = Math.min(ans,mid);
                h = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return ans;
    }
}