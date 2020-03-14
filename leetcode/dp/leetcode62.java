package leetcode.dp;

class Solution62 {
    private int count = 0;
    private int m ;
    private int n;
    public int uniquePaths(int m, int n) {
        /**
         * 构建一个m*n的矩阵
         */
        this.m = m;
        this.n = n;
        dp(0,0);
        return count;
    }

    public void dp(int a,int b){
        if (a>=m||b>=n){
            return;
        }
        if (a==m-1&&b==n-1){
            count++;
        }
        dp(a,b+1);
        dp(a+1,b);
    }
}

public class leetcode62 {

}
