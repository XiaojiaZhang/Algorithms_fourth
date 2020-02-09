package Chapter2._1;

import Chapter2.InsertionSort;
import Chapter2.SelectionSort;
import Chapter2.ShellSort;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.ArrayList;

public class _2_1_31 {
    private static Integer[] getRandomArray(int N){
        Integer[] array = new Integer[N];
        for(int i=0; i<N; i++)
            array[i] = StdRandom.uniform(-10000, 10000);
        return array;
    }

    public static void TestSelectionSort(){
        ArrayList<Double> list = new ArrayList<>();
        for(int i = 1000; i < 100000; i *= 2){
            Integer[] array = getRandomArray(i);
            Stopwatch sw = new Stopwatch();
            SelectionSort.sort(array);
            list.add(sw.elapsedTime());
        }
        for(int i = 1; i < list.size(); i++){
            StdOut.printf("%2.2f\n", list.get(i) / list.get(i-1));
        }
    }

    public static void TestInsertionSort(){
        ArrayList<Double> list = new ArrayList<>();
        for(int i = 1000; i < 100000; i *= 2){
            Integer[] array = getRandomArray(i);
            Stopwatch sw = new Stopwatch();
            InsertionSort.sort(array);
            list.add(sw.elapsedTime());
        }
        for(int i = 1; i < list.size(); i++){
            StdOut.printf("%2.2f\n", list.get(i) / list.get(i-1));
        }
    }

    public static void TestShellSort(){
        ArrayList<Double> list = new ArrayList<>();
        for(int i = 1000; i < 100000; i *= 2){
            Integer[] array = getRandomArray(i);
            Stopwatch sw = new Stopwatch();
            ShellSort.sort(array);
            list.add(sw.elapsedTime());
        }
        for(int i = 1; i < list.size(); i++){
            StdOut.printf("%2.2f\n", list.get(i) / list.get(i-1));
        }
    }

    public static void main(String[] args){
//        TestInsertionSort();
//        TestSelectionSort();
        TestShellSort();
    }
}
