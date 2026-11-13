class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& arr) {
        int n = arr.size(), m = arr[0].size();
        vector<vector<int>> res(n, vector<int>(m,0));
        for(int i = 0; i< m; i++){
            if(arr[0][i] == 1)
            break;
            res[0][i] = 1;
        }
        for(int i = 0; i< n; i++){
            if(arr[i][0] == 1)
            break;
            res[i][0] = 1;
        }
        for(int i = 1; i< n; i++){
            for(int j = 1; j< m; j++){
                if(arr[i][j] != 1){
                    res[i][j] += res[i-1][j] + res[i][j-1];
                }
            }
        }
        return res[n-1][m-1];
    }
};