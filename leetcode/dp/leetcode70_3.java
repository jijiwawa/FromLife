package leetcode.dp;

class Solution70_3 {
    /**
     * 正向迭代  动态规划
     */
    public int climbStairs(int n) {
        int [] nums  = new int[n];
        if(n>=1){
            nums[0]=1;
        }
        if(n>=2){
            nums[1]=2;
        }
        for (int i = 2; i <nums.length ; i++) {
            nums[i]=nums[i-1]+nums[i-2];
        }
        return nums[n-1];
    }
}

public class leetcode70_3 {
    public static void main(String[] args) {
        System.out.println(new Solution70_2().climbStairs(3));
    }
}
