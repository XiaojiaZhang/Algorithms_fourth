package chapter1._1;

import java.security.InvalidParameterException;

public class _1_1_5 {
    public static void main(String[] args){
        if(args.length != 2){
            throw new InvalidParameterException("命令行参数不等于2");
        }
        double x, y;
        x = Double.parseDouble(args[0]);
        y = Double.parseDouble(args[1]);
        if(x > 0 && x < 1 && y > 0 && y < 1){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
    }
}
