package chapter1._4;

public class _1_4_2 {

    private static boolean addOverflow(int a, int b){
        return (Integer.MAX_VALUE - a < b) || (Integer.MIN_VALUE - a > b);
    }

    public static int count(int[] a){
        int N = a.length;
        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                for(int k = j+1; k < N; k++){
                    //首先判断a[i]+a[j]是否会溢出，若溢出，则抛出异常，
                    //若未溢出，则继续检查a[i]+a[j], a[k]相加是否会溢出
                    if(addOverflow(a[i], a[j]) || addOverflow(a[i]+a[j], a[k])){
                        throw new ArithmeticException("整数溢出");
                    }
                    if(a[i] + a[j] + a[k] == 0)
                        cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args){
        int a = Integer.MIN_VALUE + 1;
        int b = -2;
        if(addOverflow(a, b)){
            throw new ArithmeticException("整数相加溢出");
        }
    }
}

