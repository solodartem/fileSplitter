package com.filesplitter;

/**
 * Created by asolod on 3/2/15.
 */
public interface Destination<T> {

    public void writeLine(String line);

    public T getSize();

}
