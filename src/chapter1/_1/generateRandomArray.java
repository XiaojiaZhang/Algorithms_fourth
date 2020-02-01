package chapter1._1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class generateRandomArray {
    public static double[] generate(int N, double low, double high){
        double[] array = new double[N];
        for(int i=0; i < N; i++){
            array[i] = StdRandom.uniform(low, high);
        }
        return array;
    }

    public static void displayArray(double[] array){
        for(int i=0; i < array.length; i++){
            StdOut.printf("%f\t", array[i]);
        }
        StdOut.println();
    }

    public static void main(String[] args){
        double[] array = generate(100,0.0, 1.0);
        displayArray(array);
    }
}
