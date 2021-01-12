package com.codecool.characterhandlerservice.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum CharacterClass {
    FRONT_END("problemSolving","0","design","10","algorithm","0","cleanCode","5", "testing","0"),
    BACK_END("problemSolving","10","design","0","algorithm","5","cleanCode","0", "testing","0"),
    TESTER("problemSolving","0","design","0","algorithm","0","cleanCode","5", "testing","10");


    private final Map<String, Integer> map;

    CharacterClass(String... keysAndValues) {
        if (keysAndValues.length % 2 != 0){
            throw new IllegalArgumentException("keysAndValues has odd size");
        }
        this.map = new HashMap<>();
        for (int i = 0; i < keysAndValues.length; i += 2) {
            if (keysAndValues[i] == null || keysAndValues[i + 1] == null)
                throw new NullPointerException();
            if (this.map.put(keysAndValues[i], Integer.valueOf(keysAndValues[i + 1])) != null)
                throw new IllegalArgumentException("keysAndValues has duplicate key named '" + keysAndValues[i] + "': " + Arrays.toString(keysAndValues));
        }
    }

    public Map<String, Integer> getMap() {
        return this.map;
    }

}
