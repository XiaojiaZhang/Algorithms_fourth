package Chapter2._1;

import chapter1._4.DrawPoint;
import edu.princeton.cs.algs4.*;

import java.awt.*;
import java.util.ArrayList;

public class _2_1_30 {
    private static int[] getIndex(int[] array, int t){
        if(t == 1){
            return new int[]{1};
        }
        int current = 1;
        ArrayList<Integer> index = new ArrayList<>();
        index.add(current);
        while (current*t < array.length){
            current *= t;
            index.add(current);
        }
        int[] index_array = new int[index.size()];
        for(int i=0; i < index_array.length; i++)
            index_array[i] = index.get(i);
        return index_array;
    }

    public static void shell(int[]array, int[] index_array){
        for(int k = index_array.length-1; k > -1; k--){
            int index = index_array[k];
            for(int i = index; i < array.length; i++){
                //每隔index有序
                for(int j = i; j >= index && array[j] < array[j-index]; j-=index){
                    int tmp = array[j];
                    array[j] = array[j-index];
                    array[j-index] = tmp;
                }
            }
        }
    }

    public static void main(String[] args){

        DrawPoint dp = new DrawPoint();
        StdDraw.setPenRadius(0.01);
        for(int i = 2; i < 20; i++){
            int[] array = new int[100000];
            for(int j =0; j < array.length; j++)
                array[j] = StdRandom.uniform(-1000, 1000);
            int[] index = getIndex(array, i);
            Stopwatch sw = new Stopwatch();
            shell(array, index);
            StdOut.printf("%d:%f\n", i, sw.elapsedTime());
            dp.drawPoint(i, sw.elapsedTime(), Color.RED);
        }
    }
}
