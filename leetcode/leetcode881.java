package leetcode;

import java.util.Arrays;

class Solution881 {
    public int numRescueBoats_chaoshi(int[] people, int limit) {
        int length = people.length;
        int count = 0;
        Arrays.sort(people);
        while(people[length-1]>0){
            int free = limit;
            int isfree = 2;
            if(people[length-1]==0){
                break;
            }
            int i=1;
            while(--isfree>=0){
                free-=people[length-i];
                if(free>=0){
                    people[length-i] =0;
                }else {
                    free+=people[length-i];
                    isfree+=1;
                }
                i++;
                if(length-i<0||people[length-i]==0){
                    break;
                }
            }
            count++;
            Arrays.sort(people);
        }
        return count;
    }
    public int numRescueBoats(int[] people, int limit) {
        int length = people.length;
        if (length==1){
            return 1;
        }
        int count = 0;
        Arrays.sort(people);
        int i =0;
        int j=length-1;
        while(i<j){
            if(limit-people[j]>=0){
                if (limit-people[j]-people[i]>=0){
                    i++;
                }
                j--;
                count++;
            }
            if (i==j){
                count++;
                break;
            }
        }
        return count;
    }
}

public class leetcode881 {
    public static void main(String[] args) {
        int []chars = {2,4};
        Solution881 solution621 = new Solution881();
        System.out.println(solution621.numRescueBoats(chars,5));
    }
}
