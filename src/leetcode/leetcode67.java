package leetcode;

class Solution67 {
    public String addBinary(String a, String b) {
        /**
         * 思路：先将a b字符串长度统一，不足的在前面添加0，然后依次判断对应位置，
         * 1/1 进位flag=1，其他为0
         * 最后结果去除前面的0
         */
        int length_a = a.length();
        int length_b = b.length();
        if (length_a==0){
            return b;
        }
        if (length_b==0){
            return a;
        }
        int length_same = Math.max(length_a,length_b) + 1;
        char [] chars_a = new char[length_same-length_a];
        char [] chars_b = new char[length_same-length_b];
        for (int i = 0; i <length_same-length_a ; i++) {
            chars_a[i] = '0';
        }
        for (int i = 0; i <length_same-length_b ; i++) {
            chars_b[i] = '0';
        }
        String _0_a = new String(chars_a) + a;
        System.out.println(_0_a);
        String _0_b = new String(chars_b) + b;
        System.out.println(_0_b);
        int flag = 0;
        String result [] = new String[length_same];
        for (int i = length_same-1; i >= 0 ; i--) {
            char ch_a = _0_a.charAt(i);
            char ch_b = _0_b.charAt(i);
            int _a = Integer.parseInt(String.valueOf(ch_a));
            int _b = Integer.parseInt(String.valueOf(ch_b));
            int sum = _a+ _b+ flag;
            result[i]= String.valueOf(sum%2);
            if (sum/2>=1){
                flag=1;
            }else {
                flag=0;
            }
        }
        for (String str:result
             ) {
            System.out.println(str);
        }
        StringBuffer re = new StringBuffer();
        int i ;
        for ( i = 0; i <length_same -1 ; i++) {
            if (!result[i].equals("0")){
                break;
            }
        }
        for (int j = i; j < length_same ; j++) {
            re.append(result[j]);
        }

        return re.toString();
    }
}

public class leetcode67 {
    public static void main(String[] args) {
        String str = " 123";
        String  ser1 = " ";
        System.out.println(str);
        System.out.println(ser1);
        String result = ser1 + str;
        System.out.println(result);
        System.out.println(new Solution67().addBinary("11101","101"));
    }
}
