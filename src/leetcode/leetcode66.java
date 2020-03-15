package leetcode;
class Solution66 {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int i = length-1;
        int flag=0;
        while (i>=0){
            if (digits[i]!=9){
                digits[i]++;
                return digits;
            }else {
                digits[i]=0;
                flag=1;
                i--;
            }
        }
        if (i==-1){
            int result [] = new  int[length+1];
            result[0]=1;
            return result;
        }

        return  digits;
    }
}
public class leetcode66 {
}
