package leetcode.dsu;

import java.util.Arrays;

class Solution128{
    public int longestConsecutive(int[] nums) {
        /**
         排序：  1 2 3 4 100 200

         max

         fori count++
         Math.max(max,count)
         []
         [-1,0]
         [0,1,1,2]
         */
        int len = nums.length;
        if (len==0) return 0;
        int max = 1;
        Arrays.sort(nums);
        int count = 1;
        for (int i = 1; i <len ; i++) {
            if (nums[i]==nums[i-1]+1){
                count++;
            }else if(nums[i]==nums[i-1]) {

            }else{
                max=Math.max(max,count);
                count=1;
            }
        }
        if(count!=1) max=Math.max(max,count);
        return max;
    }
}

public class leetcode128 {
}
