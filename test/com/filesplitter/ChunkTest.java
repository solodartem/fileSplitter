package com.filesplitter;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ChunkTest {

    @Test
    public void testHasNext() throws Exception {
        int qty = 10;
        List<String> stringList = new LinkedList<String>();
        Chunk chunk = new Chunk(10);

        while (chunk.hasNext()) {
            stringList.add(chunk.readLine());
        }

        assertEquals(stringList.size(), qty);
        assertEquals(stringList.get(0), Source.HEADER);
        assertEquals(stringList.get(qty - 1), Source.LINE + (qty - 1));
    }

    @Test(expected = IllegalAccessError.class)
    public void testHasNextException() throws Exception {
        int qty = 5;
        Chunk chunk = new Chunk(qty);
        do {
            chunk.readLine();
        }
        while (1 == 1);

    }

}
