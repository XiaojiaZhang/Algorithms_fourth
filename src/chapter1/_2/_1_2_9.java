package chapter1._2;

import edu.princeton.cs.algs4.Count;
import edu.princeton.cs.algs4.StdOut;

public class _1_2_9 {
    private static class Counter{
        private String id;
        public Counter(String id){
            this.id = id;
        }

        private int num = 0;
        public void increment(){
            num += 1;
        }

        public int tally(){
            return num;
        }

        public String toString(){
            return id + " " + num;
        }
    }

    private static void BinarySearch(int[] array, int N,
                                    int low, int high, Counter count){
        if(low >= high){ //如果为空
            return;
        }

        if(high - low == 1){
            if(array[low] == N){
                count.increment();
            }
            return;
        }
        else{
            int mid = low + (high - low) / 2;
            if(array[mid] == N){
                count.increment();
            }
            BinarySearch(array, N, low, mid, count);
            BinarySearch(array, N, mid+1, high, count);
        }
    }

    public static int BinarySearch(int[] array, int N){
        Counter count = new Counter("BinarySearch");
        BinarySearch(array, N, 0, array.length, count);
        return count.tally();
    }

    public static void main(String[] args){
        int[] array = new int[] {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 6};
        assert BinarySearch(array, 1) == 1;
        assert BinarySearch(array, 2) == 2;
        assert BinarySearch(array, 3) == 3;
        assert BinarySearch(array, 4) == 4;
        assert BinarySearch(array, 7) == 0;
    }
}
