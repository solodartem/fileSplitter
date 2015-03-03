package com.filesplitter;

/**
 * Created by asolod on 3/2/15.
 */
public interface Source {

    static final String HEADER="HEADER";
    static final String LINE="LINE";

    public boolean hasNext();
    public String readLine();
}
