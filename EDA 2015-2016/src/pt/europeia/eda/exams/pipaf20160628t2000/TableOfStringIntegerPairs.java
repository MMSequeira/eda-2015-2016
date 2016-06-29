package pt.europeia.eda.exams.pipaf20160628t2000;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TableOfStringIntegerPairs {
    private String[] keys;
    private Integer[] values;
    private int size = 0;

    public TableOfStringIntegerPairs() {
        keys = new String[1];
        values = new Integer[1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(final String key) {
        return valueFor(key) != null;
    }

    public Integer valueFor(final String key) {
        if (isEmpty())
            return null;

        final int rank = rankOf(key);

        if (rank < size && keys[rank].compareTo(key) == 0)
            return values[rank];

        return null;
    }

    public Iterable<String> keys() {
        final Queue<String> queue = new Queue<String>();

        for (int i = 0; i != size; i++)
            queue.enqueue(keys[i]);

        return queue;
    }

    public void put(final String key, final Integer value) {
        if (value == null) {
            delete(key);
            return;
        }

        final int rank = rankOf(key);

        if (rank < size && keys[rank].compareTo(key) == 0) {
            values[rank] = value;
            return;
        }

        if (size == keys.length)
            changeCapacityTo(2 * keys.length);

        for (int i = size; i > rank; i--) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }

        keys[rank] = key;
        values[rank] = value;

        size++;
    }

    public void delete(final String key) {
        if (isEmpty())
            return;

        final int rank = rankOf(key);

        if (rank == size || keys[rank].compareTo(key) != 0)
            return;

        for (int j = rank; j < size - 1; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }

        size--;

        keys[size] = null;
        values[size] = null;

        if (size > 0 && size == keys.length / 4)
            changeCapacityTo(keys.length / 2);
    }

    public int rankOf(final String key) {
        int first = 0;
        int last = size - 1;

        while (first <= last) {
            final int middle = first + (last - first) / 2;

            final int comparison = key.compareTo(keys[middle]);

            if (comparison < 0)
                last = middle - 1;
            else if (comparison > 0)
                first = middle + 1;
            else
                return middle;
        }
        return first;
    }

    private void changeCapacityTo(final int newCapacity) {
        final String[] newsKeys = new String[newCapacity];
        final Integer[] newValues = new Integer[newCapacity];

        for (int i = 0; i != size; i++) {
            newsKeys[i] = keys[i];
            newValues[i] = values[i];
        }

        values = newValues;
        keys = newsKeys;
    }

    // Test input: S E A R C H E X A M P L E
    public static void main(final String[] arguments) {
        final TableOfStringIntegerPairs table = new TableOfStringIntegerPairs();

        for (int i = 0; !StdIn.isEmpty(); i++) {
            final String word = StdIn.readString();
            table.put(word, i);
        }

        for (String word : table.keys())
            StdOut.println(word + " " + table.valueFor(word));
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