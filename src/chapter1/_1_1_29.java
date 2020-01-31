package chapter1;

import edu.princeton.cs.algs4.StdOut;

public class _1_1_29 {
    //找寻等于N的第一个元素位置
    public static int rank(int[] array, int N, int low, int high){
        if(low >= high){
            return -1;
        }
        int mid = low + (high - low) / 2;
        if(array[mid] == N){
            int rank_left = rank(array, N, low, mid);
            if(rank_left != -1){
                return rank_left;
            }
            else{
                return mid;
            }
        }
        else if(array[mid] < N){
            return rank(array, N, mid+1, high);
        }
        else {
            return rank(array, N, low, mid);
        }
    }

    private static int highRank(int[] array, int N, int low, int high){
        if(low >= high){
            return -1;
        }
        int mid = low + (high - low) / 2;
        if(array[mid] == N){
            int rank_right = highRank(array, N, mid+1, high);
            if(rank_right != -1){
                return rank_right;
            }
            else {
                return mid;
            }
        }
        else if(array[mid] < N){
            return highRank(array, N, mid+1, high);
        }
        else {
            return highRank(array, N, low, mid);
        }
    }

    public static int count(int[] array, int N){
        int low_rank = rank(array, N, 0, array.length);
        if(low_rank == -1){
            return 0;
        }
        else{
            int high_rank = highRank(array, N, 0, array.length);
            return high_rank-low_rank+1;
        }
    }

    public static void main(String[] args){
        int[] array = new int[]{1, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 9, 10};
        assert rank(array, 3, 0, array.length) == 2;
        assert rank(array, 4, 0, array.length) == 5;
        assert rank(array, 6, 0, array.length) == 9;
        assert count(array, 3) == 3;
        assert count(array, 4) == 2;
        assert count(array, 6) == 2;
    }
}
