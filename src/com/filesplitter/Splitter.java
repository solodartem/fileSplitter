package com.filesplitter;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by asolod on 3/2/15.
 */
public class Splitter {

    private static final int DESTINATIONS_QTY = 10;
    private static final int CHANKS_QTY = 25;

    private Destination<Integer> currentDestination;
    private PriorityQueue<Destination<Integer>> queue;

    public Splitter() {
        initDestinations();
    }


    private void initDestinations() {
        queue = new PriorityQueue<Destination<Integer>>(DESTINATIONS_QTY, new Comparator<Destination<Integer>>() {
            @Override
            public int compare(Destination<Integer> o1, Destination<Integer> o2) {
                return Integer.compare(o1.getSize(), o2.getSize());
            }
        });

        for (int i = 0; i < DESTINATIONS_QTY; i++) {
            queue.add(new ListDistination());
        }

        currentDestination = queue.poll();
    }

    public void split() {
        switchDestination();
        Source stringSource = new FileSource(CHANKS_QTY);
        while (stringSource.hasNext()) {
            String currentStr = stringSource.readLine();
            if (Source.HEADER.equals(currentStr)) {
                switchDestination();
            }
            currentDestination.writeLine(currentStr);
        }
    }

    private void switchDestination() {
        queue.offer(currentDestination);
        currentDestination = queue.poll();
    }

    public PriorityQueue<Destination<Integer>> getQueue() {
        return queue;
    }

    public static void main(String[] args) {
        Splitter splitter = new Splitter();
        splitter.split();
        System.out.println(splitter.getQueue());
    }
}
