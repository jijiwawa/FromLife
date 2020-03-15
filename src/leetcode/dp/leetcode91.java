package leetcode.dp;

class Solution91 {
    private int count  =0 ;
    private  int length ;
    public int numDecodings(String s) {
        length = s.length();

        if (length==0){
            return 0;
        }
        if (length==1){
            int temp = Integer.parseInt(s.substring(0,1));
            if (temp<1){
                return 0;
            }
            return 1;
        }

        // 接下来一个数字
        dp(s,0,1);
        // 接下来两个数字
        dp(s,0,2);
        return count;
    }
    public void dp(String s,int begin,int end){

        // 如果越界，则返回
        if (end>length){
            return;
        }

        int temp = Integer.parseInt(s.substring(begin,end));
        // 如果字符串表示的数字不在1-26则返回
        if (temp<1||temp>26){
            return;
        }else if (end-begin==2&&temp<10){
            return;
        }

        // 如果遍历结束，则返回
        if (end==length){
            count++;
            return;
        }


        // 接下来一个数字
        dp(s,end,end+1);
        // 接下来两个数字
        dp(s,end,end+2);

    }
}


public class leetcode91 {
}
