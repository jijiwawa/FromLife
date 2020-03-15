package leetcode.dp;

class Solution64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 1; i <m ; i++) {
            grid[i][0] += grid[i-1][0];
        }
        for (int i = 1; i <n ; i++) {
            grid[0][i] += grid[0][i-1];
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                int up = grid[i-1][j];
                int left = grid[i][j-1];
                if (up>left){
                    grid[i][j] += left;
                }else {
                    grid[i][j] += up;
                }
            }
        }
        return grid[m-1][n-1];
    }
}

public class leetcode64 {
    public static void main(String[] args) {
        int [][] a = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new Solution64().minPathSum(a));
    }
}

