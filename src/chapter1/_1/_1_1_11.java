package chapter1._1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.security.InvalidParameterException;

public class _1_1_11 {
    public static boolean[][] getRandomArray(int row, int col){
        boolean[][] array = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                array[i][j] = StdRandom.uniform(0, 2) == 1;
            }
        }
        return  array;
    }

    public static void printArray(boolean[][] array){
        int row = array.length;
        int col = array[0].length;
        //打印列号
        for(int i = 0; i <= col; i++){
            if(i == 0) StdOut.print("     ");
            else StdOut.printf("%5d", i);
        }
        StdOut.println();

        for(int i = 0; i < row; i++){
            for(int j = 0; j <= col; j++){
                if(j == 0) StdOut.printf("%5d", i+1); //打印行号
                else if(array[i][j-1]){
                    StdOut.printf("%5s", "*");
                }
                else {
                    StdOut.printf("     ");
                }
            }
            StdOut.println();
        }
    }

    public static void main(String[] args){
        if(args.length != 2){
            throw new InvalidParameterException();
        }
        int row = Integer.parseInt(args[0]);
        int col = Integer.parseInt(args[1]);
        boolean[][] array = getRandomArray(row, col);
        printArray(array);
    }
}
