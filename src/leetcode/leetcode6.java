package leetcode;

class Solution6 {
    public int myAtoi(String str) {
        /**
         * 1.先去除空格，到第一个不是空格为止
         * 判断第一个非空格，若为非数字、正负值，则返回0
         * 2.循环遍历数字，直到遇到非数字
         * 3.得到数字，判断数字是否越界，越界则为最大值
         */
        int result = 0;
        int length = str.length();
        if (length <= 0) {
            return result;
        }
        int i = 0;
        char ch;
        while (true) {
            ch = str.charAt(i);
            if (ch != ' ') {
                break;
            }
            if (i==length-1){
                return 0;
            }
            i++;
        }

        boolean b = ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7' || ch == '9' || ch == '8';
        int flag = 0;
        if (ch == '+') {
            flag = 1;
        } else if (ch == '-') {
            flag = -1;
        } else if (b) {
            result = choose(ch);
        } else {
            return result;
        }
        i+=1;
        while (i<length){
            char ch1 = str.charAt(i);
            if (ch1 == '0' || ch1 == '1' || ch1 == '2' || ch1 == '3' || ch1 == '4' || ch1 == '5' || ch1 == '6' || ch1 == '7' || ch1 == '9' || ch1 == '8'){
                if (flag < 0) {
                    if (result*10.0-choose(ch1)<=Integer.MIN_VALUE){
                        result=Integer.MIN_VALUE;
                        break;
                    }
                    result = result*10-choose(ch1);
                }else {
                    if (result*10.0+choose(ch1)>=Integer.MAX_VALUE){
                        result=Integer.MAX_VALUE;
                        break;
                    }
                    result = result*10+choose(ch1);
                }
            }else {
                break;
            }
            i++;
        }

        return result;
    }

    int choose(char ch) {
        int result;
        switch (ch) {
            case '1':
                result = 1;
                break;
            case '2':
                result = 2;
                break;
            case '3':
                result = 3;
                break;
            case '4':
                result = 4;
                break;
            case '5':
                result = 5;
                break;
            case '6':
                result = 6;
                break;
            case '7':
                result = 7;
                break;
            case '8':
                result = 8;
                break;
            case '9':
                result = 9;
                break;
            default:
                result = 0;
        }
        return result;
    }
}


public class leetcode6 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE* 1.0 == Integer.MAX_VALUE);
        System.out.println(new Solution6().myAtoi("-91283472332"));
        System.out.println(new Solution6().myAtoi("4193 with words"));
        System.out.println(new Solution6().myAtoi("42"));

        System.out.println(new Solution6().myAtoi("   -42"));
        System.out.println(new Solution6().myAtoi("   words and 987"));
        System.out.println(new Solution6().myAtoi(" "));




    }
}
