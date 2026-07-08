class Solution {
    boolean isSafe(int row, int col,char[][] board,int n ){
        for(int i = 0;i< row ;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        int i = row -1;
        int j= col -1;
        while(i>= 0&& j>= 0){
            if(board[i][j]=='Q'){
                return false;
            }
            i--;
            j--;
        }
        i=row-1;
        j = col+1;
        while(i>=0&&j<n){
            if(board[i][j]=='Q'){
                return false;
            }
            i--;
            j++;
        } 
        return true;

    }


    void backtrack(int row,int n , List<List<String>> res, char[][] board){
        if(row == n){
            List<String>  temp = new ArrayList<>();
            for(int i = 0;i<n;i++){
                temp.add(new String (board[i]));
            }
            res.add(temp);
            return;
        }
        for(int col = 0; col<n; col++){
            if(isSafe(row,col,board,n)){
                board[row][col] = 'Q';
                backtrack(row+1,n,res,board);
                board[row][col] ='.';
            }
        }
    }
 
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board =new char[n][n];
        for(int i = 0 ;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        backtrack(0,n,res,board);
        return res;

    }
}