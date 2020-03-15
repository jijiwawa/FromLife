package leetcode.dsu;

class Solution684 {
    private int [] relationShip;
    public int[] findRedundantConnection(int[][] edges) {
        int n =edges.length;
        int result[] = new int[2];
        if (n==0) return result;

        relationShip=new int[n];
        for (int i = 0; i <n ; i++) {
            relationShip[i]=i;
        }

        // edges 的元素要减1
        for (int i = 0; i <n ; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            int parent1 = find(node1-1);
            int parent2 = find(node2-1);
            if (parent1!=parent2){
                relationShip[parent2]=parent1;
            }else {
                result[0]=Math.min(node1,node2);
                result[1]=Math.max(node1,node2);
            }
        }
        return result;
    }


    private int find(int i) {
        int root = i;
        while (root!=relationShip[root]){
            root=relationShip[root];
        }
        while (i!=relationShip[i]){
            int temp = relationShip[i];
            relationShip[i]=root;
            i=temp;
        }

        return root;
    }

}

public class leetcode684 {
}
