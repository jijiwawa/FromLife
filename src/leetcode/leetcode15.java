package leetcode;

import java.util.*;

class Solution15 {
    private int size;
    private Stack<Integer> ans;
    private Set<List<Integer>> set ;
    private List<List<Integer>> result;

    public List<List<Integer>> threeSum(int[] nums) {
        /*
        回溯：选和不选，当选了3个之后 ,超时O(n3)
        双指针 O(n2)
         */
        size=nums.length;
        result = new LinkedList<>();
        set = new HashSet<>();
        ans = new Stack<>();
        Arrays.sort(nums);
        if (size<=2){
            return result;
        }
        for (int i = 0; i <size-2 ; i++) {

            int L = i+1;
            int R = size-1;
            int value_i = nums[i];
            // 优化1
            if (value_i>0) break;
            // 优化2
            if (i>0&&nums[i]==nums[i-1]) continue;

            while (L<R){
                int value_L = nums[L];
                int value_R = nums[R];
                if (value_L+value_R>-value_i){
                    R--;
                }else if (value_L+value_R<-value_i){
                    L++;
                }else {
                    ans.add(value_i);
                    ans.add(value_L);
                    ans.add(value_R);
//                    List<Integer> temp = new LinkedList<>(ans);
//                    if (!set.contains(temp)){
//                        result.add(temp);
//                        set.add(temp);
//                    }
                    // 优化3
                    result.add(Arrays.asList(value_i,value_L,value_R));
                    while (L<R && nums[L+1]==value_L) L++;
                    while (L<R && nums[R-1]==value_R) R--;

                    ans.clear();
                    L++;R--;
                }
            }
        }
        return result;
    }

}

public class leetcode15 {
    public static void main(String[] args) {
        int [] nums ={-1, 0, 1, 2, -1, -4};
        System.out.println(new Solution15().threeSum(nums));
    }
}
