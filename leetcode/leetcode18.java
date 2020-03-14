package leetcode;

import java.util.*;

class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        int size = nums.length;
        if (size<=3){
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i <size-3 ; i++) {
            while (i>0 && nums[i]==nums[i-1]) i++;
            int vi = nums[i];
            for (int j = i+1; j <size-2 ; j++) {
                while (j>i+1 && nums[j]==nums[j-1]) j++;
                int vj = nums[j];
                int L = j+1;
                int R = size-1;
                while (L<R){
                    int vL = nums[L];
                    int vR = nums[R];
                    int sum = vi+vj+vL+vR;
                    if (sum==target){
                        result.add(Arrays.asList(vi,vj,vL,vR));
                        while (L<R && nums[L+1]==vL) L++;
                        while (L<R && nums[R-1]==vR) R--;
                        L++;R--;

                    } else if (sum < target) {
                        L++;
                    }else {
                        R--;
                    }

                }
            }
        }
        return result;
    }

}
public class leetcode18 {
    public static void main(String[] args) {
        int nums []= {-3,-2,-1,0,0,1,2,3};
        System.out.println(new Solution18().fourSum(nums,0));
    }
}
