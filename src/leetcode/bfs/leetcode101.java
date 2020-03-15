package leetcode.bfs;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution101 {
    private StringBuffer ans_L;
    private StringBuffer ans_R;
    public boolean isSymmetric(TreeNode root) {
        /**
         * 思路:分别左子树右子树遍历，null设为-1，看最后ans是否一样
         */
        ans_L = new StringBuffer();
        ans_R = new StringBuffer();
        if (root==null){
            return true;
        }

        getAnsL(root.left);
        getAnsR(root.right);
        System.out.println(ans_L);
        System.out.println(ans_R);

        if (ans_L.toString().equals(ans_R.toString())){
            return true;
        }else {
            return false;
        }

    }

    private void getAnsR(TreeNode right) {
        if (right==null){
            ans_R.append(-1);
            return;
        }
        ans_R.append(right.val);
        getAnsR(right.right);
        getAnsR(right.left);
    }

    private void getAnsL(TreeNode left) {
        if (left==null){
            ans_L.append(-1);
            return;
        }
        ans_L.append(left.val);
        getAnsL(left.left);
        getAnsL(left.right);
    }
}

public class leetcode101 {
}
