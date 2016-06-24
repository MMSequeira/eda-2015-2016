package pt.europeia.eda.extra.session4;

import edu.princeton.cs.algs4.StdRandom;

// A "corrected" version of quicksort which actually introduces a performance bug.
public final class Quick {

    private Quick() {
        throw new RuntimeException("Attempt to instantiate package-class");
    }

    public static <Item extends Comparable<? super Item>> void sort(
            final Item[] values) {
        StdRandom.shuffle(values);

        sort(values, 0, values.length - 1);
    }

    private static <Item extends Comparable<? super Item>> void sort(
            final Item[] values, final int first, final int last) {
        if (last <= first)
            return;

        final int j = partition(values, first, last);

        sort(values, first, j - 1);
        sort(values, j + 1, last);
    }

    private static <Item extends Comparable<? super Item>> int partition(
            final Item[] values, final int first, final int last) {
        int i = first;
        int j = last + 1;

        final Item pivot = values[first];

        while (true) {

            // These "improved" loops attempt to avoid needless swaps by not
            // stopping for values equal to the pivot, thus leading to really
            // bad partitions in the face of ranges of equal values:
            do
                i++;
            while (!isLess(pivot, values[i]) && i != last);

            do
                j--;
            while (!isLess(values[j], pivot) && j != first);

            if (i >= j)
                break;

            swap(values, i, j);
        }

        swap(values, first, j);

        return j;
    }

    private static <Value extends Comparable<? super Value>> boolean isLess(
            final Value first, final Value second) {
        return first.compareTo(second) < 0;
    }

    private static void swap(final Object[] values, final int i, final int j) {
        final Object temporary = values[i];
        values[i] = values[j];
        values[j] = temporary;
    }

    public static void main(final String[] arguments) {
        final int size = 1 << 16;
        final Integer[] numbers = new Integer[size];

        for (int i = 0; i != numbers.length; i++)
            numbers[i] = 0;

        // Attempting to sort an array of zeros will lead to a
        // StackOverflowError being thrown:
        sort(numbers);
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