package leetcode.dsu;


class Solution547 {
    private int [] id;
    public int findCircleNum(int[][] M) {
        int n = M.length;
        id= new int[n];

        for (int i = 0; i <n ; i++) {
            id[i]=i;
        }

        for (int i = 0; i <n ; i++) {
            for (int j = i+1; j <n ; j++) {
                int isfriend = M[i][j];
                if (isfriend==1){
                    join(i,j);
                }
            }
        }

        int numCircle = 0;
        for (int i = 0; i <n ; i++) {
            if (i==id[i]) numCircle++;
        }

        return numCircle;

    }

    private int find(int i){
        int root = i;
        while (root!=id[root]){
            root=id[root];
        }
        // 压缩路径
        while (i!=id[i]){
            int temp = id[i];
            id[i]=root;
            i=temp;
        }
        return root;
    }

    private void join(int i , int j){
        int indexI = find(i);
        int indexJ = find(j);

        if (indexI!=indexJ){
            id[indexJ]=indexI;
        }
    }
    /**
     * [
     * [1,0,0,1],
     * [0,1,1,0],
     * [0,1,1,1],
     * [1,0,1,1]]
     */
}


public class leetcode547 {
    public static void main(String[] args) {
        int a[][]= {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.println(new Solution547().findCircleNum(a));
    }
}
