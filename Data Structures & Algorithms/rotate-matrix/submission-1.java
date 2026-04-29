class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0 ; i < n; i++){
            for(int j = i ; j< m; j++){
                int x = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = x;
            }
        }
        for(int i = 0 ; i< n; i++){
            int j = 0, k = n-1;
            while(j < k){
                int x = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = x;
                j++;
                k--; 
            }

        }
        return;
    }
}
