package com.xlftec.test;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Question2Test {

    @Test
    void rebuild() {
        Map<String, String> source= new HashMap<>();
        source.put("A", "1");
        source.put("B.A’", "2");
        source.put("B.B’", "3");
        source.put("CC.D.E", "4");
        source.put("CC.D.F’", "5");
        Map<String, Object> target = new HashMap<>();

        System.out.println(Question2.rebuild(source));
        // todo: 逐层 assert Map 中的元素检查是否相等。
    }

}