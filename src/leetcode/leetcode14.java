package leetcode;

class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        int lenght = strs.length;
        if (lenght==1){
            return strs[0];
        }else if (lenght==0){
            return "";
        }
        String temp = strs[0];
        for (int i = 1; i < lenght;i++){
            result = theSamestr(temp,strs[i]);
            if (result==null){
                return "";
            }
            temp=strs[i];
        }

        return result;
    }

    private String theSamestr(String str, String str1) {
        StringBuffer result = new StringBuffer();
        int len_1 = str.length();
        int len_2 = str1.length();
        if (len_1==0||len_2==0){
            return null;
        }
        for (int i = 0; i <Math.min(len_1,len_2) ; i++) {
            if (str.charAt(i)==str1.charAt(i)){
                result.append(str.charAt(i));
            }else {
                break;
            }

        }
        if (result.length()==0){
            return null;
        }
        return result.toString();
    }
}

public class leetcode14 {
    public static void main(String[] args) {

    }
}
