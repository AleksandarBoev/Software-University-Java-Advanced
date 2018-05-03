package com.company;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        int[] simpleArray = {1, 2, 77, 9, 23, 8};
        Arrays.sort(simpleArray);
//        Arrays.parallelSort(simpleArray);
        simpleArray = reverseArray(simpleArray);
        System.out.println(Arrays.toString(simpleArray));

        //main ends here
    }

    static int[] reverseArray(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[array.length - 1 - i];
        }
        return newArray;
    }

}
