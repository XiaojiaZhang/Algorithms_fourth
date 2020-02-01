package chapter1._1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.security.InvalidParameterException;

public class _1_1_13 {
    private static int[][] getRandomArray(int row, int col){
        int[][] array = new int[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                array[i][j] = StdRandom.uniform(-1000, 1000);
            }
        }
        return array;
    }

    private static void printArray(int[][] array){
        int row = array.length;
        int col = array[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                StdOut.printf("%5d", array[i][j]);
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
        int[][] srcArray = getRandomArray(row, col);
        int[][] destArray = new int[col][row];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                destArray[j][i] = srcArray[i][j];
            }
        }
        StdOut.println("srcArray:");
        printArray(srcArray);
        StdOut.println("destArray:");
        printArray(destArray);
    }
}
