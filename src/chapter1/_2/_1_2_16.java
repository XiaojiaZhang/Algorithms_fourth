package chapter1._2;

import edu.princeton.cs.algs4.StdOut;

public class _1_2_16 {
    public static class Rational{
        private long numerator, denominator;
        //欧几里得算法计算最大公约数字
        private static long gcd(long x, long y){
            if(x % y == 0) return y;
            else return gcd(y, x %y);
        }

        private Rational simplify(Rational a){
            long gcd = gcd(a.numerator, a.denominator);
            return new Rational(a.numerator/gcd, a.denominator/gcd);
        }

        public Rational(long numerator, long denominator){
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public Rational plus(Rational b){
            //判断分子计算是否会上溢
            assert this.denominator <= Long.MAX_VALUE / b.numerator;
            assert b.denominator <= Long.MAX_VALUE / this.numerator;
            assert this.denominator*b.numerator <= Long.MAX_VALUE - b.denominator * this.numerator;

            //判断分子计算是否会下溢
            assert this.denominator >= Long.MIN_VALUE / b.numerator;
            assert b.denominator >= Long.MIN_VALUE/ this.numerator;
            assert this.denominator*b.numerator >= Long.MIN_VALUE - b.denominator * this.numerator;

            long numerator = this.denominator * b.numerator +
                    b.denominator * this.numerator;

            //判断分母计算是否会上溢
            assert this.denominator <= Long.MAX_VALUE / b.denominator;
            //判断分母计算是否会下溢
            assert this.denominator >= Long.MIN_VALUE / b.denominator;
            long denominator = this.denominator * b.denominator;
            return simplify(new Rational(numerator, denominator));
        }

        public Rational minus(Rational b){
            Rational minus_b = new Rational(-1*b.numerator, b.denominator);
            return plus(minus_b);
        }

        public Rational times(Rational b){
            assert this.numerator <= Long.MAX_VALUE / b.numerator;
            assert this.numerator >= Long.MIN_VALUE / b.numerator;
            long numerator = this.numerator * b.numerator;

            assert this.denominator <= Long.MAX_VALUE / b.denominator;
            assert this.denominator >= Long.MIN_VALUE / b.denominator;
            long denominator = this.denominator * b.denominator;
            return simplify(new Rational(numerator, denominator));
        }

        public Rational divides(Rational b){
            Rational divides_b = new Rational(b.denominator, b.numerator);
            return times(divides_b);
        }

        public boolean equals(Rational that){
            Rational a = simplify(this);
            Rational b = simplify(that);
            return a.numerator == b.numerator && a.denominator == b.denominator;
        }

        public String toString(){
            if(denominator == 1) return numerator+"";
            return numerator + "/" + denominator;
        }
    }

    public static void main(String[] args){
        Rational a = new Rational(1, 2);
        Rational b = new Rational(1, 6);
        StdOut.println(a.plus(b));
        StdOut.println(a.minus(b));
        StdOut.println(a.times(b));
        StdOut.println(a.divides(b));
    }
}
