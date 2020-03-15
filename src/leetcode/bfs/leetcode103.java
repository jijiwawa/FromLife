package leetcode.bfs;

import java.util.*;

class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        /**
         * 先左后右，左边的用队列，右边先得用栈
         * 使用一个队列queue来存每层的数目
         */
        Map<Integer,Object> map = new HashMap<>();
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Deque<Integer> dq = new LinkedList<>();
        if (root==null) return result;
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i <size ; i++) {
                TreeNode temp = queue.poll();
                if (level%2==1){
                    dq.offerLast(temp.val);
                }else {
                    dq.offerFirst(temp.val);
                }
                if (temp.left!=null){
                    queue.offer(temp.left);
                }
                if (temp.right!=null){
                    queue.offer(temp.right);
                }
            }
            int size_dq = dq.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size_dq; i++) {
                list.add(dq.pollFirst());
            }
            result.add(list);
            level++;
        }

        return result;

    }
}

public class leetcode103 {
    public static void main(String[] args) {
        System.out.println(new Solution103().zigzagLevelOrder(null));
    }

}
