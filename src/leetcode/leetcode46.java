package leetcode;

import java.util.*;

class Solution46 {
    private List<List<Integer>> result;
    private int size;
    private int [] nums;
    public List<List<Integer>> permute(int[] nums) {
        result = new LinkedList<>();
        this.size = nums.length;
        this.nums = nums;
        if (size==0){
            return result;
        }
        LinkedList<Integer> ans = new LinkedList<Integer>();
        bt(ans);
        return result;
    }

    public void bt(LinkedList<Integer> ans){
        if (ans.size()==size){
            result.add(new LinkedList<>(ans));
        }
        for (int i = 0; i <size ; i++) {
            if (ans.contains(nums[i])){
                continue;
            }
            ans.add(nums[i]);
            bt(ans);
            ans.removeLast();
        }

    }
}
public class leetcode46 {
}
