package chapter1;

import edu.princeton.cs.algs4.StdOut;

public class _1_1_30 {
    public static boolean[][] generateArray(int N){
        boolean[][] array = new boolean[N][N];
        //0没有约数也没有倍数
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i == 0 || j == 0){
                    array[i][j] = false;
                }
                else if(_1_1_24.gcd(i, j) == 1){
                    array[i][j] = true;
                }
                else{
                    array[i][j] = false;
                }
            }
        }
        return array;
    }

    private static void displayArray(boolean[][] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                StdOut.print(array[i][j]);
                StdOut.print("\t");
            }
            StdOut.println();
        }
    }

    public static void main(String[] args){
        int N = 10;
        boolean[][] array = generateArray(N);
        displayArray(array);
    }
}
