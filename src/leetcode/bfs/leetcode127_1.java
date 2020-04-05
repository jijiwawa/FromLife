package leetcode.bfs;

import java.util.*;

class Solution127_1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /*
        优化127：减少对wordList的遍历，找当前word只替换一个字符可达的word时。
        使用一个map来存 如 dog 存 *og、d*g、do*
        结果：最后并没有优化。。。。。。不如第一种实现。。。。。。。。。
         */
        int count = 0;
        int len = beginWord.length();
        Map<String, Set<String>> map = new HashMap<>();
        for (String s : wordList
        ) {
            for (int i = 0; i < len; i++) {
//                String string = s.replace(s.charAt(i), '*');
                // 不能使用replace，replace会将字符串中所有的字符都会替换，而不是单个。
                // 应该使用substring
                String string = s.substring(0,i)+"*"+s.substring(i+1);
                if (map.containsKey(string)) {
                    map.get(string).add(s);
                } else {
                    Set<String> set = new HashSet<>();
                    set.add(s);
                    map.put(string, set);
                }
            }
        }
        Queue<String []> queue = new LinkedList<>();
        if (!wordList.contains(endWord)) return count;

        String [] list = {beginWord,String.valueOf(count)};
        queue.offer(list);
        wordList.remove(beginWord);
        while (!queue.isEmpty()) {
            String [] strings = queue.poll();
            String string = strings[0];
            int level = Integer.parseInt(strings[1]);
            if (string.equals(endWord)) {
                count = level + 1;
                break;
            }
            for (int i = 0; i < len; i++) {
                String s = string.substring(0,i)+"*"+string.substring(i+1);
                if (map.containsKey(s)) {
                    for (String temp : map.get(s)
                    ) {
                        if (wordList.contains(temp)) {
                            String [] strings1 = {temp,String.valueOf(level + 1)};
                            queue.offer(strings1);
                            wordList.remove(temp);
                        }
                    }
                }
            }
        }
        return count;
    }

}

public class leetcode127_1 {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
//        list.add("hot");
//        list.add("dot");
//        list.add("dog");
//        list.add("lot");
//        list.add("log");
//        list.add("cog");
//        System.out.println(new Solution127_1().ladderLength("hit", list.add("hot");
//        list.add("most");
//        list.add("mist");
//        list.add("miss");
//        list.add("lost");
//        list.add("fist");
//        list.add("fish");
//        System.out.println(new Solution127_1().ladderLength("lost", "miss", list));
        list.add("lest");
        list.add("leet");
        list.add("lose");
        list.add("code");
        list.add("lode");
        list.add("robe");
        list.add("lost");
        System.out.println(new Solution127_1().ladderLength("leet", "code", list));
        String string = "123456";
        System.out.println(string.substring(0,0));
        System.out.println(string.substring(6)+6);
        System.out.println(string.substring(7)+7);

    }
}
