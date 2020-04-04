package leetcode.bfs;

import java.util.*;

class Solution127_1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /*
        优化127：减少对wordList的遍历，找当前word只替换一个字符可达的word时。
        使用一个map来存 如 dog 存 *og、d*g、do*
         */
        int count = 0;
        int len = beginWord.length();
        Map<String, Set<String>> map = new HashMap<>();
        for (String s : wordList
        ) {
            for (int i = 0; i < len; i++) {
                String string = s.replace(s.charAt(i), '*');
                if (map.containsKey(string)) {
                    map.get(string).add(s);
                } else {
                    Set<String> set = new HashSet<>();
                    set.add(s);
                    map.put(string, set);
                }
            }
        }
        Queue<List<String>> queue = new LinkedList<>();
        if (!wordList.contains(endWord)) return count;
        List<String> list = new LinkedList<>();
        list.add(beginWord);
        list.add(String.valueOf(count));
        queue.offer(list);
        while (!queue.isEmpty()) {
            LinkedList<String> linkedList = (LinkedList<String>) queue.poll();
            String string = linkedList.get(0);
            int level = Integer.parseInt(linkedList.get(1));
            if (string.equals(endWord)) {
                count = level + 1;
                break;
            }
//            int i = 0;
//            while (i != wordList.size()) {
//                String str = wordList.get(i);
//                if (canChange(str, string)) {
//                    List<String> list1 = new LinkedList<>();
//                    list1.add(str);
//                    list1.add(String.valueOf(level + 1));
//                    queue.offer(list1);
//                    wordList.remove(str);
//                } else {
//                    i++;
//                }
//            }
            for (int i = 0; i < len; i++) {
                String s = string.replace(string.charAt(i), '*');
                if (map.containsKey(s)) {
                    for (String temp : map.get(s)
                    ) {
                        if (wordList.contains(temp)) {
                            List<String> list1 = new LinkedList<>();
                            list1.add(temp);
                            list1.add(String.valueOf(level + 1));
                            queue.offer(list1);
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
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(new Solution127_1().ladderLength("hit", "cog", list));

    }
}
