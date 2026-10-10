class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        int a = 0;
        vector<int> left(n,0), right(n,0);
        for(int i = 0; i< n; i++){
            if(height[a] < height[i]){
                a = i;
            }
            left[i] = height[a];
        }
        cout<<endl;
        int b = n-1;
        for(int i = n-2;i>=0; i--){
            
            if(height[b] < height[i]){
                b = i;
            }
            right[i] = height[b];
        }
        int total = 0;
        for(int i = 1; i< n-1;i++){
            total += ((min(left[i], right[i])) - height[i]);
        }
        return total;
    }
};
