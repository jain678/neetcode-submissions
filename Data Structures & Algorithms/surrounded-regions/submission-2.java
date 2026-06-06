class Solution {
    public void solve(char[][] board) {
        Queue<int[]> q = new LinkedList<>();
        int n = board.length, m = board[0].length;
        for(int i = 0 ;i< m; i++){
            if(board[0][i] == 'O'){
                q.add(new int []{0,i});
                board[0][i] = 'A';
            }
            if(board[n-1][i] == 'O'){
                q.add(new int []{n-1,i});
                board[n-1][i] = 'A';
            }
        }

        for(int i = 0 ;i< n; i++){
            if(board[i][0] == 'O'){
                q.add(new int []{i,0});
                board[i][0] = 'A';
            }
            if(board[i][m-1] == 'O'){
                q.add(new int []{i, m-1});
                board[i][m-1] = 'A';
            }
        }
        int [][] dir = {{-1, 0},{0,-1}, {0,1}, {1,0}};
        
        while(!q.isEmpty()){
            int size = q.size();
            System.out.println(q.size());
            for(int i = 0 ; i< size; i++){
                int [] t = q.poll();
                for(int j = 0 ; j< 4; j++){
                    int x = t[0] + dir[j][0];
                    int y = t[1] + dir[j][1];

                    if(x >=0 && x < n && y>=0 && y< m && board[x][y] == 'O'){
                        q.add(new int [] {x,y});
                        board[x][y] = 'A';
                    }
                }
            }
        }
        for(int i = 0 ; i< n; i++){
            for(int j = 0 ;j <m; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == 'X'){
                    continue;
                }
                else {
                    board[i][j] = 'O';
                }
            }
        }
        return ;
    }
}
