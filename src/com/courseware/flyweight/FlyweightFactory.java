package com.courseware.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    // The pool storing shared references
    private static final Map<String, SharedText> textPool = new HashMap<>();

    //Returns a shared instance of SharedText. If it doesn't exist in the pool, it is created, cached, and returned.
    public static SharedText getText(String content) {
        if (content == null || content.isEmpty()) {
            throw new IllegalArgumentException("Content cannot be null or empty.");
        }
        
        return textPool.computeIfAbsent(content, SharedText::new);
    }
}