class Solution {
    public boolean isValidSudoku(char[][] board) {
        //check each row
        for(int i = 0; i< 9; i++){
            boolean [] check = new boolean[10];
            for(int j = 0; j< 9; j++){
                if(board[i][j] == '.')
                continue;
                int idx = (board[i][j]-'0');
                if(check[idx]){
                    return false;
                }
                else{
                    check[idx] = true;
                }
            }
        }
        //check each column
        for(int i = 0; i< 9; i++){
            boolean [] check = new boolean[10];
            for(int j = 0; j< 9; j++){
                if(board[j][i] == '.')
                continue;
                int idx = (board[j][i]-'0');
                if(check[idx]){
                    return false;
                }
                else{
                    check[idx] = true;
                }
            }
        }

        //check each sub box
        int row = 0, col = 0;
        for(int i = 0; i<3; i++){
            row = i*3;
            for(int j = 0 ; j<3; j++){
                col =  j*3;
               boolean [] check = new boolean[10];
                for(int a = row; a < row + 3; a++){
                    
                    for(int b = col; b < col + 3; b++){
                        
                        if(board[a][b] == '.')
                        continue;
                        int idx = (board[a][b]-'0');
                        if(check[idx]){
                            return false;
                        }
                        else{
                            check[idx] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
}
