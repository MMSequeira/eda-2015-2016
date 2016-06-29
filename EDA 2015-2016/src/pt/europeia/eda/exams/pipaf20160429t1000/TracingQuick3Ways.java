package pt.europeia.eda.exams.pipaf20160429t1000;

import static java.lang.System.out;

/*
 *  A non-shuffling quicksort with Dijstra's three way partition which
 *  traces its execution to the console:
 */
public final class TracingQuick3Ways {
    private static int numberOfArrayReads;
    private static int numberOfArrayWrites;
    private static int numberOfComparisons;
    private static int numberOfSwaps;
    private static int numberOfRecursiveCalls;
    private static int numberOfPartitions;

    private static void resetCounts() {
        numberOfArrayReads = 0;
        numberOfArrayWrites = 0;
        numberOfComparisons = 0;
        numberOfSwaps = 0;
        numberOfRecursiveCalls = 0;
        numberOfPartitions = 0;
    }

    private TracingQuick3Ways() {
        throw new RuntimeException("Attempt to instantiate package-class");
    }

    public static <Item extends Comparable<? super Item>> void sort(
            final Item[] values) {
        resetCounts();
        out.println("Starting to sort array "
                + rangeAsString(values, 0, values.length - 1) + ":");

        sort(values, 0, values.length - 1, 1);

        out.println("Sorted array is:"
                + rangeAsString(values, 0, values.length - 1) + ".");
        out.println("Overall counts are:");
        out.println("\tNumber of recursive calls: " + numberOfRecursiveCalls);
        out.println("\tNumber of partitions: " + numberOfPartitions);
        out.println("\tNumber of comparisons: " + numberOfComparisons);
        out.println("\tNumber of swaps: " + numberOfSwaps);
        out.println("\tNumber of array reads: " + numberOfArrayReads);
        out.println("\tNumber of array writes: " + numberOfArrayWrites);
    }

    private static <Item extends Comparable<? super Item>> void sort(
            final Item[] values, final int first, final int last,
            final int depth) {
        numberOfRecursiveCalls++;

        out.println(indentation(depth) + "sorting " + (last - first + 1)
                + " items from " + first + " to " + last + " of "
                + rangeAsString(values, first, last) + ":");

        if (last <= first) {
            out.println(indentation(depth)
                    + "\tno partitioning necessary, no further sorting");
            out.println(indentation(depth) + "sort result: "
                    + rangeAsString(values, first, last));
            return;
        }

        out.println(indentation(depth) + "\tpartitioning "
                + rangeAsString(values, first, last) + ":");

        numberOfPartitions++;

        int lowest = first;
        int greatest = last;

        int i = first + 1;

        numberOfArrayReads++;

        final Item pivot = values[first];

        while (i <= greatest) {
            numberOfArrayReads++;
            numberOfComparisons++;

            final int comparison = values[i].compareTo(pivot);

            if (comparison < 0) {
                out.println(indentation(depth) + "\t\tswapping " + lowest + " ("
                        + values[lowest] + ") with " + i + " (" + values[i]
                        + ")");
                swap(values, lowest, i);
                lowest++;
                i++;
            } else if (comparison > 0) {
                out.println(indentation(depth) + "\t\tswapping " + i + " ("
                        + values[i] + ") with " + greatest + " ("
                        + values[greatest] + ")");
                swap(values, i, greatest);
                greatest--;
            } else
                i++;
        }
        out.println(indentation(depth) + "\tpartition result is: "
                + rangeAsString(values, first, last));

        sort(values, first, lowest - 1, depth + 1);
        sort(values, greatest + 1, last, depth + 1);

        out.println(indentation(depth) + "sort result: "
                + rangeAsString(values, first, last));
    }

    private static void swap(final Object[] values, final int i, final int j) {
        numberOfSwaps++;
        numberOfArrayReads += 2;
        numberOfArrayWrites += 2;

        final Object temporary = values[i];
        values[i] = values[j];
        values[j] = temporary;
    }

    private static String rangeAsString(final Object[] values, final int first,
            final int last) {
        final StringBuilder result = new StringBuilder("[");

        if (first <= last)
            for (int i = 0; i != values.length; i++) {
                if (i == first)
                    result.append('|');
                if (first <= i && i <= last)
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

    private static String indentation(int depth) {
        final StringBuilder result = new StringBuilder();

        while (depth != 0) {
            result.append('\t');
            depth--;
        }

        return result.toString();
    }

    public static void main(final String[] arguments) {
        final Integer[] values = { 10, 60, 20, 50, 30, 70, 40 };
        /*-
        for (int length = 0; length != values.length + 1; length++)
            for (int first = 0; first != values.length - length + 1; first++)
                 out.println(rangeAsString(values, first, first + length - 1));
        */

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