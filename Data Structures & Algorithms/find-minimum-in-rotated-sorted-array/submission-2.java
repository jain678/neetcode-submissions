class Solution {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        int n = nums.length;
        while(l < h){
            int m = (l + h)/2;
            // if(nums[m] <= nums[l] && nums[m] <= nums[h]){
            //     return nums[m];
            // }
            if(nums[m] > nums[h]){
                l = m+1;
            }
            else {
                h = m;
            }
        }
        return nums[l];
    }
}
