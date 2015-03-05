package com.filesplitter;

import java.util.LinkedList;

/**
 * Created by asolod on 3/2/15.
 */
public class ListDistination implements Destination<Integer> {

    private LinkedList<String> internalList = new LinkedList<String>();

    private int chunksQty = 0;

    @Override
    public void writeLine(String line) {
        internalList.add(line);
        if (Source.HEADER.equals(line)) {
            chunksQty++;
        }

    }

    @Override
    public Integer getSize() {
        return internalList.size();
    }

    @Override
    public String toString() {
        return "Size " + internalList.size() + " chunksQty =" + chunksQty +'}';
    }
}
