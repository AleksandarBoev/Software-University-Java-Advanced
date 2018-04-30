package com.company;

public class Main {

    public static void main(String[] args) {
        int a = 5;
        fillUntil(a, 3);
        int b = 2;
        fillUntil(b, 3);
        int c = a | b;
        fillUntil(c, 3);
        int d = ~c;
        fillUntil(d, 3);
        // write your code here
    }

    static void fillUntil(int number, int length) {
        String binaryString = Integer.toBinaryString(number);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length - binaryString.length(); i++) {
            sb.append('0');
        }
        System.out.println(sb.toString() + binaryString);
    }

}
