package com.xlftec.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class Question2Test {

    @Test
    void rebuild() {
        Map<String, String> source = new HashMap<>();
        source.put("A", "1");
        source.put("B.A", "2");
        source.put("B.B", "3");
        source.put("CC.D.E", "4");
        source.put("CC.D.F", "5");

        Map<String, Object> target = new HashMap<>();

        target.put("A", "1");
        path(target).path("B").getMap().put("A", "2");
        path(target).path("B").getMap().put("B", "3");
        path(target).path("CC").path("D").getMap().put("E", "4");
        path(target).path("CC").path("D").getMap().put("F", "5");

        assertMapEqual(target, Question2.rebuild(source));
    }

    private static void assertMapEqual(Map<String, Object> target, Map<String, Object> source) {
        for (Map.Entry<String, Object> entry : target.entrySet()) {
            if (entry.getValue() instanceof String) {
                Assertions.assertEquals(entry.getValue(), source.get(entry.getKey()));
            } else {
                assertMapEqual((Map<String, Object>) entry.getValue(), (Map<String, Object>) source.get(entry.getKey()));
            }
        }
    }

    private static class PathFinder {
        private Map<String, Object> pathNode;

        private PathFinder(Map<String, Object> pathNode) {
            this.pathNode = pathNode;
        }

        public PathFinder path(String path) {
            this.pathNode = (Map<String, Object>) pathNode.computeIfAbsent(path, key -> new HashMap<String, Object>());
            return this;
        }

        public Map<String, Object> getMap() {
            return pathNode;
        }
    }

    private static PathFinder path(Map<String, Object> pathMap) {
        return new PathFinder(pathMap);
    }

}