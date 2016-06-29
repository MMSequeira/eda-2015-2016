package pt.europeia.eda.exams.pipaf20160628t1000;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TableOfStringIntegerPairs {
    private int size;
    private Node first;

    private static class Node {

        private final String key;
        private Integer value;
        private Node next;

        public Node(final String key, final Integer value, final Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }

    public TableOfStringIntegerPairs() {
        size = 0;
        first = null;
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
        for (Node node = first; node != null; node = node.next)
            if (key.equals(node.key))
                return node.value;

        return null;
    }

    public Iterable<String> keys() {
        final Queue<String> queue = new Queue<String>();

        for (Node node = first; node != null; node = node.next)
            queue.enqueue(node.key);

        return queue;
    }

    public void put(final String key, final Integer value) {
        if (value == null) {
            delete(key);
            return;
        }

        for (Node node = first; node != null; node = node.next)
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }

        first = new Node(key, value, first);

        size++;
    }

    public void delete(final String key) {
        if (isEmpty())
            return;

        if (key.equals(first.key)) {
            size--;
            first = first.next;
        } else {
            Node node = first;
            while (node.next != null && !key.equals(node.next.key))
                node = node.next;
            if (node.next != null) {
                size--;
                node.next = node.next.next;
            }
        }
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