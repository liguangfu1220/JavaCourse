package com.geekbang;

public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        int num1 = 1;
        int num2 = 2;
        obj.add(num1, num2);
    }

    public int add(int a, int b){
        int c = 0;
        if (a != 0 && b != 0) {
            c = a + b;
        }
        if (a == 0 && b != 0) {
            c = b;
        }
        if (a != 0 && b == 0) {
            c = a;
        }
        return c;
    }
}