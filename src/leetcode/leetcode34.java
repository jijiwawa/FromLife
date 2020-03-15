package leetcode;
class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int size = nums.length;
        int result [] = {-1,-1};
        if (size<=0){
            return result;
        }
        int i = 0,j=size-1;
        int mid= (j+i)/2;
        while (i<=j){
            mid = (j+i)/2;
            int vmid = nums[mid];
            if (vmid==target){
                result[0]=mid;
                result[1]=mid;
                break;
            }else if(vmid<target){
                i=mid+1;
            }else {
                j=mid-1;
            }
        }
        int L_j = mid-1;
        while (i<=L_j){
            int midL = (L_j+i)/2;
            int vmid = nums[midL];
            if (vmid==target){
                result[0]=midL;
                L_j=midL-1;
            }else if(vmid<target){
                i=midL+1;
            }else {
                L_j=midL-1;
            }
        }

        int R_i = mid+1;
        while (R_i<=j){
            int midR = (R_i+j)/2;
            int vmid = nums[midR];
            if (vmid==target){
                result[1]=midR;
                R_i=midR+1;
            }else if(vmid<target){
                R_i=midR+1;
            }else {
                j=midR-1;
            }
        }

        return result;
    }
}
public class leetcode34 {
    public static void main(String[] args) {
        int a [] ={0,0,1,1,1,2,2,3,3,3,4,4,4,4,5,5,6,6,6,8,10,10};
        System.out.println(new Solution34().searchRange(a,4));
    }
}
