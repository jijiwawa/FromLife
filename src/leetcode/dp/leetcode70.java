package leetcode.dp;

class Solution70 {
    public int climbStairs(int n) {
        /**
         * 超时 用例：45
         */
        if (n==1){
            return 1;
        }else if (n==2){
            return 2;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }
}

public class leetcode70 {
}
