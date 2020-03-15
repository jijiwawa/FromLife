package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        /**
         * 思路，构建长列以及圈内的集合，判断当前数值是否在三个集合中，若已在则不符合数独，遍历结束，则是数独
         */
        Map<Integer, Set<Character>> maprow = new HashMap<>();
        Map<Integer, Set<Character>> mapcol = new HashMap<>();
        Map<Integer, Set<Character>> mapcircle = new HashMap<>();
        for (int i = 0; i < 9 ; i++) {
            maprow.put(i, new HashSet<Character>());
            mapcol.put(i, new HashSet<Character>());
            mapcircle.put(i, new HashSet<Character>());
        }

        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j <9 ; j++) {
                char ch = board[i][j];
                if (ch=='.'){
                    continue;
                }
                if (maprow.get(i).contains(ch)||mapcol.get(j).contains(ch)){
                    return false;
                }else{
                    maprow.get(i).add(ch);
                    mapcol.get(j).add(ch);
                }
                int num = getNum(i,j);
                if (mapcircle.get(num).contains(ch)){
                    return false;
                }else {
                    mapcircle.get(num).add(ch);
                }
            }
        }

        return true;
    }

    public int getNum(int i, int j){
        int num = 0;
        if (i<=2){
            if (j<=2) num=0;
            else if (j<=5) num=1;
            else num=2;
        }else if (i<=5){
            if (j<=2) num=3;
            else if (j<=5) num=4;
            else num=5;
        }else {
            if (j<=2) num=6;
            else if (j<=5) num=7;
            else num=8;
        }
        return num;
    }
}

public class leetcode36 {
    public static void main(String[] args) {
    }
}