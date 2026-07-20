class Solution {
    void shift(int[][] grid, int row, int col) {
        int temp = 0;
        for (int i = row-1; i >= 0; i--) {
            for (int j = col-1; j >= 0; j--) {
                if (j == 0) {
                    temp = j;
                    continue;
                }
                temp = grid[i][j];
                grid[i][j] = grid[i ][j-1];
                grid[i][j-1] = temp;
            }
            if(i!=0){
                int x = grid[i][temp];
                grid[i][temp]= grid[i-1][col-1];
                grid[i-1][col-1] = x;
            }
        }
        return;
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> matrix = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        k = k%(m*n);
        for (int i = 0; i < k; i++) {
            shift(grid, m, n);
        }

        for (int i = 0; i < m; i++) {
            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j < n;j++) {
                row.add(grid[i][j]);
            }

            matrix.add(row);
        }
        return matrix;
    }
}