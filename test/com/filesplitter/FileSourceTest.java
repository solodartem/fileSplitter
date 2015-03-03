package com.filesplitter;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileSourceTest {

    @Test
    public void testHasNext() throws Exception {
        int chunksQty = 3;
        List<String> stringList = new LinkedList<String>();
        FileSource fileSource = new FileSource(chunksQty);

        while (fileSource.hasNext()) {
            stringList.add(fileSource.readLine());
        }

        // calculate HEADERs qty
        int headersQty = 0;
        while (stringList.contains(Source.HEADER)) {
            stringList.remove(Source.HEADER);
            headersQty++;
        }

        assertEquals(headersQty, chunksQty);

    }

}
