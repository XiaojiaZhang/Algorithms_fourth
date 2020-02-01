package chapter1._1;

import java.security.InvalidParameterException;

public class _1_1_14 {
    public static int lg(int N){
        if(N < 1){
            throw new InvalidParameterException();
        }
        int pow = 1;
        int i;
        for(i = 0; pow < N; i++, pow*=2);
        return  i-1;
    }
    public static void main(String[] args){
        assert lg(10) == 3;
        assert lg(2) == 0;
        assert lg(1) == -1;
    }
}
