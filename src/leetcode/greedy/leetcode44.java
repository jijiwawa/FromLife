package leetcode.greedy;

import java.util.Scanner;

class Solution44{
    public boolean isMatch(String s, String p) {
        /**
         * 判断当前索引0是否相等，相等则下一个
         *
         */
        if (s==null&&p==null) return true;


        if (s.equals("")&&p.equals("")) return true;

        if (p.equals("*")) return true;

        if (s.equals("")&&p.charAt(0)=='*'){
            int i = 1;
            while (i<p.length()&&p.charAt(i)=='*'){
                i++;
            }
            if (i!=p.length()){
                return false;
            }else {
                return true;
            }
        }

        if (s.equals("")||p.equals("")) return false;

        if (s==null||p==null) return false;

        // if (p.equals("")) System.out.println("is \" \"");
        // 若p[0]='?' 或者 p[0]=s[0],比较下一个字符
        if (p.charAt(0)=='?'||s.charAt(0)==p.charAt(0)) return isMatch(s.substring(1),p.substring(1));

        if (p.charAt(0)=='*'){
            if (p.length()>1&&p.charAt(1)=='*'){
                int i = 1;
                while (i<p.length()&&p.charAt(i)=='*'){
                    i++;
                }
                return isMatch(s,p.substring(i-1));
            }else {
                // p[0]='*'
                // 匹配s 0个字符
                // 匹配s 1个或者多个字符
                return isMatch(s, p.substring(1)) || isMatch(s.substring(1), p);
            }
        }else {
            return false;
        }

    }
}

public class leetcode44 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String strS = in.nextLine().trim();
            String strP = in.nextLine().trim();
            System.out.println(new Solution44().isMatch(strS,strP));
        }
        String  s = "a";
        System.out.println(s.substring(1)+"a");
    }
}
