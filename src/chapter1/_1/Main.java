package chapter1._1;

public class Main {
    public static void main(String[] args){
        //1.1.1
        assert (0 + 15) / 2 == 7;
        assert 2e-6 * 100000000.1 == 200.0000002;
        assert true && false || true && true;
        //1.1.2
        assert (1+2.236) / 2 == 1.618;
        assert 1 + 2 + 3 + 4.0 == 10.0;
        assert 4.1 >= 4;
        assert "33".equals(1 + 2 + "3");
    }
}
