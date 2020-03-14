package leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution130 {
    public void solve(char[][] board) {
        /**
         * 先创建一个矩阵matrix，从边界开始遍历，
         * 若为O，则bfs，为X matrix对应位置为X
         * 边界遍历完之后，遍历中间区域，若natrix对应位置为O则为O其他的为X
         */
        int m = board.length;
        if (m==0) return;
        int n = board[0].length;
        int tag [][] = new int[m][n];
        int steps [] = {-1,0,1,0,0,1,0,-1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n ; j++) {
                if (i!=0&&j!=0&&i!=(m-1)&&j!=(n-1)){
                    continue;
                }
                char ch = board[i][j];
                if (ch=='O'){
                    tag[i][j]=1;
                    Queue<List<Integer>> q = new LinkedList<>();
                    List<Integer> list = new LinkedList<>();
                    list.add(i);
                    list.add(j);
                    q.offer(list);
                    while (!q.isEmpty()) {
                        List<Integer> temp = q.poll();
                        int ii = temp.get(0);
                        int jj = temp.get(1);
                        for (int k = 0; k < 8; k += 2) {
                            int i_next = ii + steps[k];
                            int j_next = jj + steps[k + 1];
                            if (i_next < 0 || i_next >= m || j_next < 0 || j_next >= n||tag[i_next][j_next]==1) {
                                continue;
                            }
                            char value = board[i_next][j_next];
                            if (value=='O'){
                                tag[i_next][j_next]=1;
                                List list1 = new ArrayList();
                                list1.add(i_next);
                                list1.add(j_next);
                                q.offer(list1);
                            }
                        }
                    }
                }
            }
        }
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j <n-1 ; j++) {
                if (tag[i][j]==0){
                    board[i][j]='X';
                }
            }
        }
    }
}

public class leetcode130 {
    public static void main(String[] args) {
        char [][] matrix = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        new  Solution130().solve(matrix);
    }
}


/*
[["O","X","X","O","X"]
,["X","O","O","X","O"]
,["X","O","X","O","X"]
,["O","X","O","O","O"]
,["X","X","O","X","O"]]
 */