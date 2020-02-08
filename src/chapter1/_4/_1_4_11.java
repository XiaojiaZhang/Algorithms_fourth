package chapter1._4;

import edu.princeton.cs.algs4.StdOut;

public class _1_4_11 {
    public static class StaticSETOfInts{
        private int[] array;
        public StaticSETOfInts(int[] a){
            array = a;
        }
        private int contain(int low, int high, int key){
            if(low >= high){
                return -1;
            }
            int mid = low + (high - low) / 2;
            if(array[mid] == key){
                return mid;
            }
            else if(array[mid] > key){
                return contain(low, mid, key);
            }
            else {
                return contain(mid+1, high, key);
            }
        }

        public boolean contain(int key){
            return contain( 0, array.length, key) != -1;
        }

        private int leftIndex(int low, int high, int key){
            if(low >= high){
                return -1;
            }
            int mid = low + (high - low) / 2;
            if(array[mid] == key){
                int left_index = leftIndex(low, mid, key);
                if(left_index != -1){
                    return left_index;
                }
                else {
                    return mid;
                }
            }
            else if(array[mid] > key){
                return leftIndex(low, mid, key);
            }
            else{
                return leftIndex(mid+1, high, key);
            }
        }

        private int rightIndex(int low, int high, int key){
            if(low >= high){
                return -1;
            }
            int mid = low + (high - low) / 2;
            if(array[mid] == key){
                int right_index = rightIndex(mid+1, high, key);
                if(right_index != -1){
                    return right_index;
                }
                else {
                    return mid;
                }
            }
            else if(array[mid] > key){
                return rightIndex(low, mid, key);
            }
            else{
                return rightIndex(mid+1, high, key);
            }
        }

        public int howMany(int key){
            int left_index = leftIndex(0, array.length, key);
            if(left_index == -1){
                return 0;
            }
            else{
                return rightIndex(0, array.length, key) - left_index + 1;
            }
        }
    }

    public static void main(String[] args){
        int[] array = new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 6};
        StaticSETOfInts ssi = new StaticSETOfInts(array);
        StdOut.println(ssi.howMany(2));
        StdOut.println(ssi.howMany(3));
        StdOut.println(ssi.howMany(7));
    }
}
