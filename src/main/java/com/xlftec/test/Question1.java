package com.xlftec.test;


import java.util.Comparator;

import static com.xlftec.test.Util.swap;

public class Question1 {



    public static void partition(int[] array) {
        partition(array, Util.decendingOrder);
    }

    public static void partition(int[] array, Comparator<Integer> comparator) {
        int j = 0;
        int tmp = 0;
        for (int i = 0; i < array.length; i++) {
            if (comparator.compare(array[i], 0) < 0) {
                if (i != j) {
                    swap(array, i, j, tmp);
                }
                j++;
            }
        }
    }

    private static int partition(int[] array, int p, int r) {
        int pivot = array[r];
        int i = p - 1;
        int tmp;
        for (int j = p; j < r; j++) {
            if (Util.decendingOrder.compare(array[j], pivot) < 0) {
                i++;
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        tmp = array[i + 1];
        array[i + 1] = array[r];
        array[r] = tmp;
        return i + 1;
    }
}
