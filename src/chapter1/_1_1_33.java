package chapter1;

import edu.princeton.cs.algs4.StdOut;

public class _1_1_33 {
    public static double dot(double[]x, double[] y){
        double sum = 0;
        if(x.length != y.length){
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < x.length; i++){
            sum += x[i] * y[i];
        }
        return sum;
    }

    public static double[] mult(double[][]a, double[] x){
        if(a[0].length != x.length){
            throw new IllegalArgumentException();
        }
        double[] res = new double[a.length];
        for(int i = 0; i < a.length; i++){
            res[i] = dot(a[i], x);
        }
        return res;
    }

    public static double[] mult(double[]y, double[][]a){
        if(y.length != a.length){
            throw new IllegalArgumentException();
        }
        double[] res = new double[a[0].length];
        for(int i = 0; i < res.length; i++){
            double[] col = new double[a.length];
            for(int j =0; i < col.length; j++){
                col[j] = a[i][j];
            }
            res[i] = dot(y, col);
        }
        return res;
    }

    public static double[][] mult(double[][]a, double[][]b){
        if(a[0].length != b.length){
            throw new IllegalArgumentException();
        }
        double[][] res = new double[a.length][b[0].length];
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < b[0].length; j++){
                double[] col = new double[b.length];
                for(int k = 0; k < col.length; k++)
                    col[k] = b[k][j];
                res[i][j] = dot(a[i], col);
            }
        }
        return res;
    }

    public static double[][] transpose(double[][]a){
        double res[][] = new double[a[0].length][a.length];
        for(int i = 0; i < a.length; i++){
            for(int j=0; j < a[0].length; j++){
                res[j][i] = a[i][j];
            }
        }
        return res;
    }

    private static void displayArray(double[][] array){
        for(int i=0; i<array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                StdOut.printf("%f\t", array[i][j]);
            }
            StdOut.println();
        }
    }

    public static void main(String[] args){
        double[][] a = new double[][]{
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4}
        };
        double[][] b = new double[][]{
                {1, 2},
                {1, 2},
                {1, 2},
                {1, 2}
        };
//        double[][] mult = mult(a, b);
//        displayArray(mult);
        displayArray(transpose(a));
    }
}
