class Solution {
    public int search(int[] nums, int target) {
        int l = 0, h = nums.length-1;
        while(l <= h){
            int mid = (l + h)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                h--;
            }
            else{
                l++;
            }
        }
        return -1;
    }
}
