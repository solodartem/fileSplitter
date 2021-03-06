package com.filesplitter;

/**
 * Created by asolod on 3/2/15.
 */
public class Chunk implements Source {

    private final int maxCount;
    private int currentCount = 0;

    public Chunk(int maxCount) {
        this.maxCount = maxCount;
    }

    @Override
    public boolean hasNext() {
        return currentCount < maxCount;
    }

    @Override
    public String readLine() {

        if (!hasNext()) {
            throw new IllegalAccessError();
        }

        String result = currentCount==0?HEADER:LINE+currentCount;
        currentCount++;
        return  result;
    }
}
