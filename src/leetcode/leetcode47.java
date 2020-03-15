package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution47 {
    private List<List<Integer>> result;
    private Set<List<Integer>> set ;
    private int size;
    private int [] nums;
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new LinkedList<>();
        this.size = nums.length;
        this.nums = nums;
        this.set =new HashSet<>();
        if (size==0){
            return result;
        }
        LinkedList<Integer> ans = new LinkedList<Integer>();
        bt(ans);
        return result;
    }

    public void bt(LinkedList<Integer> ans){
        if (ans.size()==size){
            LinkedList<Integer> temp = new LinkedList<>(ans);
            if (!set.contains(temp)){
                result.add(temp);
                set.add(temp);
            }
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

public class leetcode47 {
}
