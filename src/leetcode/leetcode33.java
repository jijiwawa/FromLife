package leetcode;

class Solution33 {
    public int search(int[] nums, int target) {
        int size = nums.length;
        int index =-1;

        if (size==0||(size==1&&nums[0]!=target)){
            return index;
        }

        int i =0;
        int value = nums[0];
        if (value==target){
            return i;
        }else if (value<target){
            i++;
            while (true){
                if (nums[i]==target){
                    index = i;
                    break;
                }
                i++;
                if (i==size||nums[i]<nums[i-1]){
                    index=-1;
                    break;
                }
            }
        }else {
            i=size-1;
            while (true){
                if (nums[i]==target){
                    index = i;
                    break;
                }
                i--;
                if (i==0||nums[i+1]<nums[i]){
                    index=-1;
                    break;
                }
            }
        }
        return index;
    }
}

public class leetcode33 {
    public static void main(String[] args) {
        int [] num= {4,5,6,7,0,1,2};
        System.out.println(new Solution33().search(num,0));
    }
}
