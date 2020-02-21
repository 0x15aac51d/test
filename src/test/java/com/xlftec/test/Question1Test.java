package com.xlftec.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Question1Test {

    @Test
    void separate() {
        int[] target = {6, 4, 5, 1, -2, -1, 0, -3, -9};
        int[] array = {6, 4, -3, 5, -2, -1, 0, 1, -9};
        Question1.partition(array);
        System.out.println(Arrays.toString(array));
        assertArrayEquals(target, array);
    }
}