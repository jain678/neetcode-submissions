class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int [] nextGreaterHeight = new int[n];
        int [] prevGreaterHeight = new int[n];
        Arrays.fill(nextGreaterHeight, -1);
        Arrays.fill(prevGreaterHeight, -1);
        int mx = -1;
        for(int i = 0 ; i< n; i++){
            if(height[i] < mx)
            prevGreaterHeight[i] = mx;
            mx = Math.max(mx, height[i]);
        }
        mx = -1;
        for(int i = n-1 ; i>=0; i--){
            if(height[i] < mx)
            nextGreaterHeight[i] = mx;
            mx = Math.max(mx, height[i]);
        }
        int mxWater = 0, res = 0;
        for(int i = 0 ; i < n; i++){
            System.out.println(nextGreaterHeight[i] + " " + prevGreaterHeight[i]);
            if(nextGreaterHeight[i] == -1 || prevGreaterHeight[i] == -1){
                continue;
            }
            res += Math.min(prevGreaterHeight[i], nextGreaterHeight[i]) - height[i];
        }

        return res;
    }
}
