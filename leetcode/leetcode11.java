package leetcode;

class Solution11 {
    public int maxArea(int[] height) {
        // 双指针
        int left = 0;
        int right = height.length-1;
        int result = 0;
        while (left<right){
            int hihg_l = height[left];
            int hihg_r = height[right];
            result = Math.max(result,(right-left) * Math.min(hihg_l,hihg_r));
            if (hihg_l<=hihg_r){
                left++;
            }else {
                right--;
            }
        }
        return result;
    }
    /*
    public int maxArea(int[] height) {
        // 暴力

        int result = 0;

        int size = height.length;
        if (size<2){
            return result;
        }
        for (int i = 0; i <size-1 ; i++) {
            for (int j = i+1; j <size ; j++) {
                int high = Math.min(height[i],height[j]);
                int width = j-i;
                int maxarea = high * width;
                if (maxarea> result){
                    result =maxarea;
                }
            }
        }

        return result;

    }
    */
}

public class leetcode11 {
    public static void main(String[] args) {
        int [] a = {1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution11().maxArea(a));
    }
}
