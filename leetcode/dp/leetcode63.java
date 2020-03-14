package leetcode.dp;

class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int temp =obstacleGrid[0][0];
        for (int i = 0; i <n ; i++) {
            if (obstacleGrid[0][i]==0){
                obstacleGrid[0][i]=-1;
            }else {
                obstacleGrid[0][i]=-0;
                i++;
                while (i<n){
                    obstacleGrid[0][i]=-0;
                    i++;
                }
                break;
            }
        }
        obstacleGrid[0][0]=temp;
        for (int i = 0; i <m ; i++) {
            if (obstacleGrid[i][0]==0){
                obstacleGrid[i][0]=-1;
            }else {
                obstacleGrid[i][0]=-0;
                i++;
                while (i<m){
                    obstacleGrid[i][0]=-0;
                    i++;
                }
                break;
            }
        }

        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                if (obstacleGrid[i][j]==1){
                    obstacleGrid[i][j]=0;
                }else {
                    obstacleGrid[i][j] =obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
                }
            }
        }
        return -obstacleGrid[m-1][n-1];
    }
}

public class leetcode63 {
}
