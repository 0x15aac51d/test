package com.xlftec.test;

import java.util.Comparator;

public class Util {

    public static void swap(int[] array, int lIndex, int rIndex) {
        int tmp = array[lIndex];
        array[lIndex] = array[rIndex];
        array[rIndex] = tmp;
    }

    public static void swap(int[] array, int lIndex, int rIndex, int tmp) {
        tmp = array[lIndex];
        array[lIndex] = array[rIndex];
        array[rIndex] = tmp;
    }

    public static Comparator<Integer> ascendingOrder = (lValue, rValue) -> lValue - rValue;
    public static Comparator<Integer> decendingOrder = (lValue, rValue) -> rValue - lValue;
}
