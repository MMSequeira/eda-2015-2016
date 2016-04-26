package pt.europeia.eda.piazza.experiments;

import static java.lang.System.out;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

class SortExperiment {

    private final Sorter<Integer> sorter;
    private final int size;
    private final String name;

    public SortExperiment(final Sorter<Integer> sorter, final int size, final String name) {
        this.sorter = sorter;
        this.size = size;
        this.name = name;
    }
    
    public void run() {
        // Setting up:
        final Integer[] values = new Integer[size];
        for (int i = 0; i != size; i++)
            values[i] = i;
        StdRandom.shuffle(values);        

        // Running:
        out.println("Experimenting " + name + ":");
        out.println("\tSize: " + size);
        out.println("\tBefore: " + Arrays.toString(values));
        
        sorter.sort(values);
        
        out.println("\tAfter:  " + Arrays.toString(values));
    }

}