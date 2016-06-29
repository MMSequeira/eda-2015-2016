package pt.europeia.eda.exams.pipaf20160628t1000;

import static java.lang.System.out;

import pt.europeia.eda.exams.pipaf20160429t1000.TracingQuick3Ways;

public final class TracingInsertion {

    private static int numberOfArrayReads;
    private static int numberOfArrayWrites;
    private static int numberOfComparisons;
    private static int numberOfSwaps;
    private static int numberOfPasses;

    private static void resetCounts() {
        numberOfArrayReads = 0;
        numberOfArrayWrites = 0;
        numberOfComparisons = 0;
        numberOfSwaps = 0;
        numberOfPasses = 0;
    }

    public static void sort(final double[] values) {
        resetCounts();

        out.println("Starting to sort array "
                + rangeAsString(values, 0, values.length - 1) + ":");

        for (int numberOfSortedItems = 1; numberOfSortedItems < values.length; numberOfSortedItems++) {
            out.println("\tPass " + (numberOfPasses + 1) + " inserting values["
                    + numberOfSortedItems + "] = " + values[numberOfSortedItems]
                    + " into " + numberOfSortedItems + " sorted items: "
                    + rangeAsString(values, 0, numberOfSortedItems - 1) + ":");

            for (int i = numberOfSortedItems; i != 0
                    && isLess(values[i], values[i - 1]); i--) {
                swap(values, i - 1, i);
                out.println("\t\tAfter swap: "
                        + rangeAsString(values, 0, numberOfSortedItems) + ":");
            }
            
            out.println("\tPass result is: "
                    + rangeAsString(values, 0, numberOfSortedItems) + ":");

            numberOfPasses++;
        }

        out.println("Sorted array is:"
                + rangeAsString(values, 0, values.length - 1) + ".");
        out.println("Overall counts are:");
        out.println("\tNumber of passes: " + numberOfPasses);
        out.println("\tNumber of comparisons: " + numberOfComparisons);
        out.println("\tNumber of swaps: " + numberOfSwaps);
        out.println("\tNumber of array reads: " + numberOfArrayReads);
        out.println("\tNumber of array writes: " + numberOfArrayWrites);
    }

    private static boolean isLess(final double first, final double second) {
        out.println("\t\tComparing " + first + " with " + second);

        numberOfComparisons++;
        numberOfArrayReads++;
        numberOfArrayWrites++;

        return first < second;
    }

    private static void swap(final double[] values, final int i, final int j) {
        out.println("\t\tSwapping values[" + i + "] = " + values[i]
                + " with values[" + j + "] = " + values[j] + ")");

        numberOfSwaps++;
        numberOfArrayReads++;
        numberOfArrayWrites++;

        final double temporary = values[i];
        values[i] = values[j];
        values[j] = temporary;
    }

    private static String rangeAsString(final double[] values, final int first,
            final int last) {
        final StringBuilder result = new StringBuilder("[");

        if (first <= last)
            for (int i = 0; i != values.length; i++) {
                if (i == first)
                    result.append('|');
                if (first <= i && i <= last + 1)
                    result.append(values[i]);
                else
                    result.append('*');
                if (i == last)
                    result.append('|');
                if (i != values.length - 1)
                    result.append(' ');
            }
        else {
            final int empty = first;
            for (int i = 0; i != values.length; i++) {
                if (i == empty)
                    result.append("|| ");
                if (first <= i && i <= last)
                    result.append(values[i]);
                else
                    result.append('*');
                if (i != values.length - 1)
                    result.append(' ');
            }
            if (empty == values.length)
                result.append(" ||");
        }

        return result.append("]").toString();
    }

    public static void main(final String[] arguments) {
        final double[] values = { 40, 30, 20, 10 };

        sort(values);
    }

}

/*
 * Copyright 2015 and 2016, Robert Sedgewick and Kevin Wayne.
 * 
 * Copyright 2015 and 2016, Manuel Menezes de Sequeira.
 * 
 * This file is a derivative work of the code which accompanies the textbook
 * 
 * Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne, Addison-Wesley
 * Professional, 2011, ISBN 0-321-57351-X. http://algs4.cs.princeton.edu
 * 
 * This code is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This code is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this code. If not, see http://www.gnu.org/licenses.
 * 
 * Any errors found in this code should be assumed to be the responsibility of
 * the author of the modifications to the original code (viz. Manuel Menezes de
 * Sequeira).
 */