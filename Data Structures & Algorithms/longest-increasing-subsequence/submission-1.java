class Solution {
    private int nxtGreater(List<Integer> lt, int x){
        int l= 0, h = lt.size() -1;
        while(l<h){
            int mid = (l+h)/2;
            if(lt.get(mid) == x){
                return mid;
            }
            if(lt.get(mid) < x){
                l = mid+1;
            }
            else if(lt.get(mid) > x){
                h = mid;
            }
        }
        return h;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> lt = new ArrayList<>();
        lt.add(nums[0]);
        int ans = 1;
        for(int i = 1; i< n; i++){
            if(nums[i] > lt.get(lt.size()-1)){
                lt.add(nums[i]);
            }
            else {
                int idx = nxtGreater(lt, nums[i]);
                lt.set(idx, nums[i]);
            }
        }
        return lt.size();
    }
}
