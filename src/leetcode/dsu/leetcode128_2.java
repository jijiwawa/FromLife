package leetcode.dsu;

import java.util.HashSet;
import java.util.Set;

class Solution128_1{
    public int longestConsecutive(int[] nums) {
        /**
         hash_table来做
         */
        int len = nums.length;
        if (len==0) return 0;
        int max=1;
        // 添加进hashset
        Set<Integer> set = new HashSet<>();
        for (int num:nums
             ) {
            set.add(num);
        }

        for (int num:set
             ) {
            int count = 1;
            int temp = num;
            // 如果包含了该比该元素小1的数，证明该数已经在队列中
            if (!set.contains(num-1)){
                while (set.contains(temp+1)){
                    count+=1;
                    temp+=1;

                }
                max=Math.max(max,count);
            }
        }

        return max;
    }
}

public class leetcode128_2 {
}
