package leetcode.bfs;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        /*
        层序遍历二叉树。当前层数level
        当level变化时，将上一个节点的值传入result中。最后队列为空的时候，将最后一个节点放入result中
         */
        List<Integer> result = new ArrayList<>();
        if (root==null) return result;
        int level = 0;
        int prev =root.val;
        int now = 0;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> qLevel = new LinkedList<>();
        q.offer(root);
        qLevel.offer(0);
        while (!q.isEmpty()){
            TreeNode temp = q.poll();
            int tempLevel = qLevel.poll();
            if (tempLevel!=now){
                now=tempLevel;
                result.add(prev);
            }
            prev=temp.val;
            if (temp.left!=null){
                q.offer(temp.left);
                qLevel.offer(tempLevel+1);
            }
            if (temp.right!=null){
                q.offer(temp.right);
                qLevel.offer(tempLevel+1);
            }

        }
        result.add(prev);
        return result;
    }
}

public class leetcode199 {
}
