package chapter1._1;


public class _1_1_8 {
    public static void main(String[] args){
        System.out.println((int)'b');
        System.out.println('b' + 'c'); //两个char类型的相加结果默认使用整数打印,
        //'b'对应的ASCII编码值为98, c为99 , 'b'+'c'结果为197
        System.out.println((char)('a' + 4));
    }
}
