package leetcode;

import java.util.Arrays;

class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        /*
        排序,双指针
         */
        int result = 0;
        int size = nums.length;
        if (size<=2){
            return result;
        }
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < size-2 ; i++) {
            int L=i+1;
            int R=size-1;
            while (L < R){
                int sum = nums[L]+nums[R] +nums[i];
                int sub ;
                if (sum<target){
                    L++;
                    sub = target-sum;
                }else if (sum>target){
                    R--;
                    sub = sum-target;
                }else {
                    return sum;
                }
                if (sub<=min){
                    min=sub;
                    result =sum;
                }
            }
        }


        return result;
    }
}
public class leetcode16 {
    public static void main(String[] args) {
        int [] nums = {-1,2,1,-4};
        int [] nums1 = {0,2,1,-3};
        int num2[] = {1,2,4,8,16,32,64,128};


//        System.out.println(new Solution16().threeSumClosest(nums,1));
        System.out.println(new Solution16().threeSumClosest(num2,82));

    }
}
