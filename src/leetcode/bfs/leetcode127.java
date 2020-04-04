package leetcode.bfs;

import java.util.*;

class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /*
        1.不存在转换序列
        1.1（wordList中不存在endWord)
        1.2(beginWord只换一个字母在wordList中没有匹配的字符)
        1.3(转换的中间word只换一个字母在wordList中没有匹配的字符)   1.2 1.3可以结合为一个
        2.存在
        2.1 将beginWord入队
        2.2 若beginWord替换一个字符在wordList中有对应的word，将这些word入队。记录beginword，避免循环。
            count++记录经过了几次替换。
        2.3 终止条件。遍历结束（队空）或者beginword替换一个字符在wordList中没有对应的word break。
         */
        int count = 0;
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
                count = level+1;
                break;
            }
            int i = 0;
            while (i != wordList.size()) {
                String str = wordList.get(i);
                if (canChange(str, string)) {
                    List<String> list1 = new LinkedList<>();
                    list1.add(str);
                    list1.add(String.valueOf(level + 1));
                    queue.offer(list1);
                    wordList.remove(str);
                } else {
                    i++;
                }
            }
        }
        return count;
    }

    private boolean canChange(String str, String string) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != string.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

}

public class leetcode127 {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(new Solution127().ladderLength("hit","cog",list));

    }
}
