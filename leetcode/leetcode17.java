package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution17 {
    private Map<Integer,Character[]> map;
    List<String> result;
    StringBuffer ans ;
    String str ;
    int size;
    Character[] ch2 = {'a','b','c'};
    Character[] ch3 = {'d','e','f'};
    Character[] ch4 = {'g','h','i'};
    Character[] ch5 = {'j','k','l'};
    Character[] ch6 = {'m','n','o'};
    Character[] ch7 = {'p','q','r','s'};
    Character[] ch8 = {'t','u','v'};
    Character[] ch9 = {'w','x','y','z'};

    Solution17(){
        map = new HashMap<>();
        map.put(2,ch2);
        map.put(3,ch3);
        map.put(4,ch4);
        map.put(5,ch5);
        map.put(6,ch6);
        map.put(7,ch7);
        map.put(8,ch8);
        map.put(9,ch9);
    }

    public List<String> letterCombinations(String digits) {
        size=digits.length();
        ans = new StringBuffer();
        result = new LinkedList<>();
        str=new String(digits);
        if (size==0){
            return result;
        }
        backtrace(0,ans);

        return result;
    }

    void backtrace(int index,StringBuffer ans){
        if (index==size){
            result.add(new String(ans));
            return;
        }
        int digit = Integer.parseInt(str.substring(index,index+1));
        for (char ch :map.get(digit)
             ) {
            ans.append(ch);
            backtrace(index+1,ans);
            ans.deleteCharAt(index);
        }
    }
}

public class leetcode17 {
    public static void main(String[] args) {
//        StringBuffer stringBuffer = new StringBuffer();
//        stringBuffer.append(1);
//        System.out.println(stringBuffer.toString());
//        stringBuffer.append(2);
//        System.out.println(stringBuffer.toString());
//        stringBuffer.deleteCharAt(1);
//        System.out.println(stringBuffer.toString());
        System.out.println(new Solution17().letterCombinations("23"));

    }
}
