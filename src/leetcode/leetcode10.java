package leetcode;

import java.util.*;

class Solution10 {
    public boolean isMatch(String s, String p) {
        /**
         *   '.' 匹配任意单个字符
         *   '*' 匹配零个或多个前面的那一个元素
         *   p 为空，直接false  s 为空 判断p有没有*
         *   先用hash表统计每个字母出现的次数
         */
        boolean result = true;
        List<Map<Character,Integer>> hash_s = new ArrayList<>();
        List<Map<Character,Integer>> hash_p = new ArrayList<>();
        int length_s = s.length();
        int length_p = p.length();
        char ch = s.charAt(0);
        Map<Character,Integer> h_s = new Hashtable<>();
        h_s.put(ch,1);
        int count = 1;
        for (int i = 1; i < length_s; i++) {
            char ch1 = s.charAt(i);
            if (ch1==ch){
                h_s.replace(ch,count,count+1);
                count++;
            }else {
                hash_s.add(new Hashtable<>(h_s));
                h_s.clear();
                ch=ch1;
                h_s.put(ch1,1);
                count=1;
            }
        }
        hash_s.add(new Hashtable<>(h_s));

        h_s.clear();
        count = 1;

        ch = p.charAt(0);
        h_s.put(ch,1);

        for (int i = 1; i < length_p; i++) {
            char ch1 = p.charAt(i);
            if (ch1==ch){
                h_s.replace(ch,count,count+1);
                count++;
            }else {
                hash_p.add(new Hashtable<>(h_s));
                h_s.clear();
                ch=ch1;
                h_s.put(ch1,1);
                count=1;
            }
        }
        hash_p.add(new Hashtable<>(h_s));


        for (Map<Character,Integer> map :hash_s
             ) {
            for (Map.Entry<Character,Integer> entry: map.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }

        System.out.println();

        for (Map<Character,Integer> map :hash_p
        ) {
            for (Map.Entry<Character,Integer> entry: map.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
        /**
         * 遍历s，若key不同，看key_p 是否为 "." s_value = 1 ps next;
         * 							 s_value != 1 p next 是否为*,y psnext, n false
         * 						"*" : p next
         * key相同，value_s > value_p : 看后面是否有 "."、"*"
         * 	       value_s = value_p : 看下一个key
         * 	       value_s < value_p : false
         * 当s.next 和 p.next 同时为null的时候才true
         */
        int size_s = hash_s.size();
        int size_p = hash_p.size();

        int i=0,j=0;

        Map<Character,Integer> ht_s = (Hashtable<Character, Integer>) hash_s.get(i);
        Map<Character,Integer> ht_p = (Hashtable<Character, Integer>) hash_s.get(j);
        char key_s='0',key_p='1';
        int value_s=0,value_p=0;

        while (i<size_s&&j<size_p){

            if (value_s==0){
                key_s = getMapKey(ht_s);
                value_s= getMapValue(ht_s);
            }

            if (value_p==0){
                key_p = getMapKey(ht_p);
                value_p= getMapValue(ht_p);
            }

            if (key_s==key_p){

            }else {
                if (key_p=='.'){
                    if (value_p==1){
                        // . 只有一个
                    }else {
                        // . 有多个 需要减去 key_s
                    }

                }else {
                    // 如果下个是*有戏
                    //if ()
                    // 否则
                    result =false;
                    break;
                }
            }

            i++;
            j++;
            if (i==size_s&&j==size_p){
                break;
            }
        }


        return result;

    }

    char getMapKey(Map<Character, Integer> hashtable){
        char key = '0';
        for (Map.Entry<Character, Integer> entry : hashtable.entrySet()) {
            key =  entry.getKey();
        }
        return key;
    }

    int getMapValue(Map<Character, Integer> hashtable){
        int value = '0';
        for (Map.Entry<Character, Integer> entry : hashtable.entrySet()) {
            value =  entry.getValue();
        }
        return value;
    }
}

public class leetcode10 {
    public static void main(String[] args) {
        new Solution10().isMatch("mississippi","mis*is*p*.");
    }
}
