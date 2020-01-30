package chapter1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class _1_1_15 {

    private static int[] getRandomArray(int N, int low, int high){
        int[] array = new int[N];
        for(int i =0; i < N; i++){
            array[i] = StdRandom.uniform(low, high);
        }
        return array;
    }

    private static void displayArray(int[] array){
        for(int i = 0; i < array.length; i++){
            StdOut.print(array[i]);
            StdOut.print(" ");
        }
        StdOut.println();
    }

    private static int[] histogram(int[] array, int M){
        int[] resArray = new int[M];
        for(int i = 0; i < resArray.length; i++){
            resArray[i] = 0;
        }

        for(int i=0; i < array.length; i++){
            if(array[i] < M){
                resArray[array[i]] += 1;
            }
        }
        return resArray;
    }

    public static void main(String[] args){
        int[] array = getRandomArray(20, 0, 10);
        int[] hist = histogram(array, 15);
        StdOut.println("array:");
        displayArray(array);
        StdOut.println("histogram:");
        displayArray(hist);
    }

}
