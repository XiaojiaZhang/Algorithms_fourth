package chapter1._2;

import edu.princeton.cs.algs4.StdOut;

public class _1_2_6 {

    public static boolean isCircularRotation(String s1, String s2){
        //由于同一字符可能在字符串中出现多次，因此在检查两个字符串是否互为回环变位时
        //需要多次查找字符串首字符可能对应的正确位置
        //例如，　ACTGACG 与　TGACGAC互为回环变位
        //第一个字符串中的Ａ对应的是第二个字符串中第二个Ａ，而非第一个Ａ

        char first = s2.charAt(0);
        int start_index = 0;
        while(start_index < s1.length()){
            int index = s1.substring(start_index).indexOf(first);
            if(index == -1){ //如果未找到
                return false;
            }
            else {
                if((s1.substring(start_index+index) + s1.substring(0, index+start_index)).equals(s2)){
                    return true;
                }
                start_index = index + 1;
            }
        }
        return false;
    }

    public static void main(String[] args){
        StdOut.println(isCircularRotation("ACTGACG", "TGACGAC"));
        StdOut.println(isCircularRotation("TGACGAC", "ACTGACG"));
    }
}
