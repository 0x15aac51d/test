package com.xlftec.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Question2 {

    public static Map<String, Object> rebuild(Map<String, String> pathAndValue) {
        HashMap<String, Object> result = new HashMap<>();
        pathAndValue.forEach((key, value) -> {
            String[] paths = key.split("\\.");
            setValue(result, paths, value);
        });
        return result;
    }

    private static void setValue(Map<String, Object> map, String[] paths, String value) {
        Map<String, Object> lastNode = map;
        int lastPathIndex = paths.length > 1 ? paths.length - 2 : -1;
        String itemKey = paths[lastPathIndex + 1];
        for (int i = 0; i <= lastPathIndex; i++) {
            String currentPath = paths[i];
            Object uncast = lastNode.computeIfAbsent(currentPath, key -> new HashMap<String, Object>());
            if (uncast instanceof Map) {
                lastNode = (Map<String, Object>) uncast;
            } else {
                throw new IllegalArgumentException("路径异常：路径中不能含有其他路径作为前缀。");
            }
        }
        lastNode.put(itemKey, value);
    }

}
