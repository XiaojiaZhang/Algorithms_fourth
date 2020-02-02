package chapter1._2;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;

public class _1_2_11 {
    public static class SmartDate{
        private int month, day, year;

        //判断是否闰年
        private boolean isLeapYear(int year){
            return ((year % 100 != 0 && year % 4 == 0) ||
                    (year % 400 == 0));
        }

        private int[] dayOfMonth = new int[]{
                0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 29
        };

        private void validateDate(int month, int day, int year){
            boolean monthRight = month > 0 && month < 13;
            if(!monthRight){
                throw new IllegalArgumentException("月份输入有误！");
            }
            boolean dayRight;
            if(isLeapYear(year) && month == 2){
                dayRight = (day <= dayOfMonth[13]);
            }
            else{
                dayRight = (day <= dayOfMonth[month]);
            }

            if(!dayRight){
                throw new IllegalArgumentException("日期输入有误！");
            }
        }

        public SmartDate(int month, int day, int year){
            validateDate(month, day, year);
            this.month = month;
            this.day = day;
            this.year = year;
        }

        public int day(){ return day; }
        public int month(){ return month; }
        public int year(){ return year; }

        public String toString(){
            return month + "/" +  day + "/" + year;
        }
    }

    public static void main(String[] args){
        SmartDate sd = new SmartDate(12, 3, 2016);
        StdOut.println(sd);
        SmartDate sd2 = new SmartDate(2, 29, 2017);
        StdOut.println(sd2);
    }
}
