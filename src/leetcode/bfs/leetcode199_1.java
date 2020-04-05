package leetcode.bfs;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution199_1 {
    public List<Integer> rightSideView(TreeNode root) {
        /*
        不用记录层数level
        结果差不了多少
         */
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        int prev = root.val;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode temp = q.poll();
                if (i == len - 1) result.add(temp.val);
                if (temp.left != null) q.offer(temp.left);
                if (temp.right != null) q.offer(temp.right);
            }
        }
        return result;
    }
}

public class leetcode199_1 {
}
