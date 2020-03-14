package leetcode;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int size =nums.length;
        int result = 0;
        if (size==0){
            return result;
        }
        int l = 0;
        int r = size-1;
        while (l<=r){
            if (nums[(l+r)/2]==target){
                result = (l+r)/2;
                break;
            }else if (nums[(l+r)/2]<target){
                l = (l+r)/2 + 1;
            }else {
                r = (l+r)/2 -1;
            }
        }
        return l;
    }
}

public class leetcode35 {
}
