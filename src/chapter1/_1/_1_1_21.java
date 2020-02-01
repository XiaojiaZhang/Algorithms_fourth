package chapter1._1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

public class _1_1_21 {
    private static class user{
        private String name;
        private int total;
        private int num;
        public user(String name, int total, int num){
            this.name = name;
            this.total = total;
            this.num = num;
        }
        public void display(){
            StdOut.printf("%10s\t%5d\t%5d\t%.3f\n",
                    this.name, this.total, this.num,
                    this.total / (double)this.num);
        }
    }

    public static ArrayList<user> readUserInfo(){
        ArrayList<user> users = new ArrayList<>();
        String line;
        while((line = StdIn.readLine()) != null){
            String[] array = line.split(" ");
            users.add(new user(array[0],
                    Integer.parseInt(array[1]),
                    Integer.parseInt(array[2])));
        }
        return users;
    }

    public static void displayUsers(ArrayList<user> users){
        for(user u:users){
            u.display();
        }
    }

    public static void main(String[] args){
        ArrayList<user> users = readUserInfo();
        displayUsers(users);
    }
}
