package chapter1._2;

import edu.princeton.cs.algs4.StdOut;

public class _1_2_13 {
    public static class Date{
        private final int month;
        private final int day;
        private final int year;
        public Date(int m, int d, int y){
            month = m;
            day = d;
            year = y;
        }

        public Date(String date){
            String[] fields = date.split("/");
            month = Integer.parseInt(fields[0]);
            day = Integer.parseInt(fields[1]);
            year = Integer.parseInt(fields[2]);
        }

        public int month(){
            return month;
        }
        public int year(){
            return year;
        }
        public int day(){
            return day;
        }

        public String toString(){
            return month + "/" + day + "/" + year;
        }

        public boolean equals(Object x){
            if(this == x) return true;
            if(x == null) return false;
            if(this.getClass() != x.getClass()) return false;
            Date that = (Date)x;
            if(this.day != that.day) return false;
            if(this.month!= that.month) return false;
            if(this.year!= that.year) return false;
            return true;
        }
    }

    public static class Transaction{
        private String who;
        private Date when;
        private double amount;
        public Transaction(String who, Date when, double amount){
            this.who = who;
            this.when = when;
            this.amount = amount;
        }

        // Example "Truing 5/22/1939 11.99"
        public Transaction(String transaction){
            String[] fields = transaction.split("\\s+");
            who = fields[0];
            when = new Date(fields[1]);
            amount = Double.parseDouble(fields[2]);
        }

        public String who(){ return who; }
        public Date when(){ return when; }
        public double amount(){ return amount; }

        public String toString(){
            return "who:" + who + "\t" + "when:" + when + "\t" + "amount:" + amount;
        }

        public boolean equals(Object that){
            if(this == that) return true;
            if(this.getClass() != that.getClass()) return false;
            Transaction that_ = (Transaction)that;
            if(!who.equals(that_.who)) return false;
            if(!when.equals(that_.when)) return false;
            if(Math.abs(amount - that_.amount) > 0.00001) return false;
            return true;
        }
    }

    public static void main(String[] args){
        Transaction a = new Transaction("Turing 5/22/1939   11.99");
        StdOut.println(a);
    }
}
