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

        Map<String, Object> target = path().end("A", "1")
                .newPath().path("B").end("A", "2")
                .newPath().path("B").end("B", "3")
                .newPath().path("CC").path("D").end("E", "4")
                .newPath().path("CC").path("D").end("F", "5")
                .getMap();

        assertMapEqual(target, Question2.rebuild(source));
    }

    private static void assertMapEqual(Map<String, Object> target, Map<String, Object> source) {
        Assertions.assertEquals(target.entrySet().size(), source.entrySet().size());
        for (Map.Entry<String, Object> entry : target.entrySet()) {
            Assertions.assertNotNull(source.get(entry.getKey()));
            if (entry.getValue() instanceof String) {
                Assertions.assertEquals(entry.getValue(), source.get(entry.getKey()));
            } else {
                assertMapEqual((Map<String, Object>) entry.getValue(), (Map<String, Object>) source.get(entry.getKey()));
            }
        }
    }

    private static class PathBuilder {
        private Map<String, Object> firstNode;
        private Map<String, Object> pathNode;

        private PathBuilder(Map<String, Object> pathNode) {
            this.firstNode = pathNode;
            this.pathNode = firstNode;
        }

        public PathBuilder path(String path) {
            this.pathNode = (Map<String, Object>) pathNode.computeIfAbsent(path, key -> new HashMap<String, Object>());
            return this;
        }

        public Map<String, Object> getMap() {
            return firstNode;
        }

        public PathBuilder end(String key, String value) {
            pathNode.put(key, value);
            return this;
        }

        public PathBuilder newPath() {
            this.pathNode = firstNode;
            return this;
        }
    }

    private static PathBuilder path(Map<String, Object> pathMap) {
        return new PathBuilder(pathMap);
    }

    private static PathBuilder path() {
        return new PathBuilder(new HashMap<>());
    }

}