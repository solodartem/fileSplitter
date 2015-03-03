package com.filesplitter;

/**
 * Created by asolod on 3/2/15.
 */
public class FileSource implements Source {

    private final int chunksQty;
    private int currentQty = 0;
    private Chunk currentChunk;

    public FileSource(int chunksQty) {
        this.chunksQty = chunksQty;
        this.currentQty = 1;
        this.currentChunk = new Chunk(generateRandInt());
    }

    private int generateRandInt() {
        return (int)(Math.random()*10)+1;
    }

    private void setupNewChunk() {
        currentQty++;
        currentChunk = new Chunk(generateRandInt());
    }

    @Override
    public boolean hasNext() {
        return currentQty < chunksQty || currentChunk.hasNext();
    }

    @Override
    public String readLine() {
        if (!currentChunk.hasNext()) {
            setupNewChunk();
        }
        return currentChunk.readLine();
    }
}
