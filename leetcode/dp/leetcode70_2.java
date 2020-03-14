package leetcode.dp;

class Solution70_2 {
    /**
     * 反向递归超时
     */
    private int [] nums ;
    public int climbStairs(int n) {
        nums = new int[n];
        if(n>=1){
            nums[0]=1;
        }
        if(n>=2){
            nums[1]=2;
        }

        return dp(n-1);
    }
    public int dp(int n ){
        if (nums[n]!=0){
            return nums[n];
        }
        return dp(n -1 ) + dp( n-2 );
    }
}

public class leetcode70_2 {
    public static void main(String[] args) {
        System.out.println(new Solution70_2().climbStairs(3));
    }
}
