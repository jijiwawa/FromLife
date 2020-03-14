package leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution542 {
    private int m ;
    private int n;
    public int[][] updateMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int [][] result = matrix.clone();
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                int temp = matrix[i][j];
                if (temp==0){
                    continue;
                }else {
                    result[i][j] = bfs(matrix,i,j);
                }
            }
        }
        return result;
    }
    public int bfs(int[][] matrix , int i , int j){
        int steps [] = {-1,0,1,0,0,1,0,-1};
        Queue<List<Integer>> q = new LinkedList<>();
        List list = new ArrayList();
        list.add(i);
        list.add(j);
        list.add(0);
        q.offer(list);
        while (!q.isEmpty()){
            List<Integer> temp = q.poll();
            int ii = temp.get(0);
            int jj = temp.get(1);
            int level =temp.get(2);
            for (int k = 0; k <8 ; k+=2) {
                int i_next = ii+steps[k];
                int j_next = jj + steps[k+1];
                if (i_next<0||i_next>=m||j_next<0||j_next>=n){
                    continue;
                }
                int value = matrix[i_next][j_next];
                if (value==0){
                    return level+1;
                }
                List list1 = new ArrayList();
                list1.add(i_next);
                list1.add(j_next);
                list1.add(level+1);
                q.offer(list1);
            }
        }
        return 0;
    }
}

public class leetcode542 {
}
