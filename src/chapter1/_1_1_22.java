package chapter1;

import edu.princeton.cs.algs4.StdOut;

public class _1_1_22 {
    private static int rank(int[] array, int N, int low, int high, int recur){
        int i = recur;
        while(i-- > 0){
            StdOut.print("-");
        }
        StdOut.printf(" %d,%d\n", low, high);

        if(low >= high){
            StdOut.println();
            return -1; //未找到
        }
        else{
            int mid = low + (high - low) /2;
            if(array[mid] == N){
                return mid;
            }
            else if(array[mid] > N){
                return rank(array, N, low, mid, recur+1);
            }
            else {
                return rank(array, N, mid+1, high, recur+1);
            }
        }
    }

    public static int rank(int[] array, int N){
        return rank(array, N, 0, array.length, 1);
    }

    public static void main(String[] args){
        int[] array = new int[100];
        for(int i = 0; i < array.length; i++)
            array[i] = i;
        int index = rank(array, 5);
        StdOut.printf("index: %d", index);
    }
}
