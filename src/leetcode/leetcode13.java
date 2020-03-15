package leetcode;

class Solution13 {
    public int romanToInt(String s) {
        /*
        I 判断下一个是不是 V X
        X                   L C
        C                   D M
         */
        int result = 0;
        int i=1;
        int lenght = s.length();
        char ch = s.charAt(0);

        if (lenght==1){
            return choose1(ch);
        }
        result+=choose1(ch);
        while (i<lenght){
            char ch1;
            ch1 = s.charAt(i);
            if (ch == 'I') {
                if (ch1=='V'||ch1=='X'){
                    result+=choose1(ch1)-2;
                }else {
                    result+=choose1(ch1);
                }

            } else if(ch == 'X'){
                if (ch1=='L'||ch1=='C'){
                    result+=choose1(ch1)-20;
                }else {
                    result+=choose1(ch1);
                }

            } else if( ch == 'C'){
                if (ch1=='M'||ch1=='D'){
                    result+=choose1(ch1)-200;
                }else {
                    result+=choose1(ch1);
                }

            }else {
                result+=choose1(ch1);

            }
            ch = ch1;
            i++;
        }
        return result;
    }

    int choose1(char num){
        int result;
        switch (num){
            case 'M':result = 1000;break;
//            case 'CM':result =900;break;
            case 'D':result =500;break;
//            case 'CD':result =400 ;break;
            case 'C':result =100;break;
//            case 'XC':result =90;break;
            case 'L':result =50;break;
//            case 'XL':result =40;break;
            case 'X':result =10;break;
//            case 'IX':result =9;break;
            case 'V':result =5;break;
//            case 'IV':result =4;break;
            default:result=1;
        }
        return result;
    }



}

public class leetcode13 {
    public static void main(String[] args) {
        System.out.println(new Solution13().romanToInt("III"));
        System.out.println(new Solution13().romanToInt("IV"));
        System.out.println(new Solution13().romanToInt("IX"));
        System.out.println(new Solution13().romanToInt("LVIII"));
        System.out.println(new Solution13().romanToInt("MCMXCIV"));






    }
}
