package leetcode.dp;

class Solution96 {
    private int [] result ;

    public int numTrees(int n) {
        if (n==0) return 0;
        result = new int[n+1];

        result[0] = 1;
        result[1]=1;
        for (int i = 2; i <=n ; i++) {
            for (int j = 0; j < i; j++) {
                result[i] += result[j] * result[i-1-j];
            }
        }
        return result[n];
    }
}

public class leetcode96 {
    public static void main(String[] args) {
        System.out.println(new Solution96().numTrees(3));
    }
}
