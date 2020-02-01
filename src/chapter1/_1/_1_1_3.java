package chapter1._1;

import java.security.InvalidParameterException;

public class _1_1_3 {
    public static void main(String[] args){
        if(args.length != 3){
            System.out.println(args.length);
            throw new InvalidParameterException();
        }
        if(Integer.parseInt(args[0]) == Integer.parseInt(args[1]) &&
            Integer.parseInt(args[1]) == Integer.parseInt(args[2])){
            System.out.println("equal");
        }
        else{
            System.out.println("not equal");
        }
    }
}
