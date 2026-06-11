package com.courseware.flyweight;

public class SharedText {
    // Private to prevent external modification. The intrinsic, immutable state
    private final String content;

    public SharedText(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}