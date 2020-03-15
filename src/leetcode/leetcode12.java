package leetcode;

class Solution12 {
    public String intToRoman(int num) {
        int nums [] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int index=0;
        int temp =num;
        StringBuffer result = new StringBuffer();
        while (temp>0){
            int count = temp/nums[index];
            for (int i = 0; i <count ; i++) {
                result.append(choose1(nums[index]));
            }
            temp-=count*nums[index];
            index++;
        }
        return result.toString();
    }

    String choose1(int num){
        String result;
        switch (num){
            case 1000:result ="M";break;
            case 900:result ="CM";break;
            case 500:result = "D";break;
            case 400:result = "CD";break;
            case 100:result="C";break;
            case 90:result="XC";break;
            case 50:result="L";break;
            case 40:result="XL";break;
            case 10:result="X";break;
            case 9:result="IX";break;
            case 5:result="V";break;
            case 4:result="IV";break;
            default:result="I";
        }
        return result;
    }

    public String intToRoman1(int num) {
        // 先从大到小输出罗马字母

        /**
         * I             1
         * V             5
         * X             10
         * L             50
         * C             100
         * D             500
         * M             1000
         */
        int nums [] = {1000,500,100,50,10,5,1};
        int temp = num;
        int index = 0;
        StringBuffer result = new StringBuffer();
        while (temp>0){
            int now = nums[index];
            int count = temp/now;
            if (count>0){
                temp-=count*now;
                if (count==4){
                    String str ;
                    int len = result.length();
                    boolean flag = false;
                    switch (now){
                        case 100:
                            if (len==0){
                                str="CD";
                                flag=true;
                            }else if (result.charAt(len-1)=='D'){
                                str = "CM";
                            }else {
                                str="CD";
                                flag=true;
                            }
                            break;
                        case 10:
                            if (len==0){
                                str="XL";
                                flag=true;
                            }else if (result.charAt(len-1)=='L'){
                                str = "XC";
                            }else {
                                str="XL";
                                flag=true;
                            }
                            break;
                        default:
                            if (len==0){
                                str="IV";
                                flag=true;
                            }
                            else if (result.charAt(len-1)=='V'){
                                str = "IX";
                            }else {
                                str="IV";
                                flag=true;
                            }
                            break;
                    }
                    if (flag){
                        result.append(str);
                    }else {
                        result.replace(len-1,len,str);
                    }
                }else {
                    for (int i = 0; i < count ; i++) {
                        result.append(choose(now));
                    }
                }
            }
            index++;
        }
        return result.toString();
    }

    char choose(int num){
        char result ;
        switch (num){
            case 1000:result ='M';break;
            case 500:result = 'D';break;
            case 100:result='C';break;
            case 50:result='L';break;
            case 10:result='X';break;
            case 5:result='V';break;
            default:result='I';
        }
        return result;
    }


}

public class leetcode12 {
    public static void main(String[] args) {
//        System.out.println(new Solution12().intToRoman(3));
//        System.out.println(new Solution12().intToRoman(4));
//
//        System.out.println(new Solution12().intToRoman(9));
//
//        System.out.println(new Solution12().intToRoman(58));

//        System.out.println(new Solution12().intToRoman(1994));
        System.out.println(new Solution12().intToRoman(40));





    }
}
