package leetcode;

import java.util.Arrays;

class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        /*
        思路: 1 先统计tasks中任务每个任务的个数 int count[] = new int[26]
              2 给n以count降序的方式填入，若填满则下一次循环，没填满也下一次循环
              3 重新给count降序排序，重复2直到所有任务被执行完毕
         */
        int time =0;
        int lenght = tasks.length;
        int count[] = new int[26];
        if (lenght==0){
            return time;
        }
        for (char c:tasks
             ) {
            count[c-'A']++;
        }
        Arrays.sort(count);
        while (count[25]>0){
            int cycle = 0;
            while (cycle<=n){
                if (count[25]==0){
                    break;
                }
                if (count[25-cycle]>0){
                    count[25-cycle]--;
                }
                else {
                    cycle=n+1;
                    break;
                }
                cycle++;
            }
            time+=cycle;
            Arrays.sort(count);
        }

        return time;
    }
}

public class leetcode621 {
    public static void main(String[] args) {
        char []chars = {'A','A','A','B','B','B'};
        Solution621 solution621 = new Solution621();
        System.out.println(solution621.leastInterval(chars,2));
    }
}
