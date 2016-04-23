package pt.europeia.eda.piazza;

import static java.lang.System.out;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 *  This version of the class adds:
 *  1. A size attribute and a size() method.
 *  2. A copy constructor receiving any other LinkedStack with a compatible
 *  type of item.
 *  3. A toString() method using StringBuilder. 
 */

public class LinkedStack<Item> implements Iterable<Item> {

    private Node<Item> first;
    private int size;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;

        private Node(final Item item, final Node<Item> next) {
            this.item = item;
            this.next = next;
        }
    }

    public LinkedStack() {
        first = null;
        size = 0;
    }

    public <OtherItem extends Item> LinkedStack(
            final LinkedStack<OtherItem> other) {
        Node<Item> last = null;
        for (Node<OtherItem> node = other.first; node != null; node = node.next) {
            if (last == null)
                first = last = new Node<Item>(node.item, null);
            else {
                last.next = new Node<Item>(node.item, null);
                last = last.next;
            }
        }

        size = other.size;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(final Item item) {
        first = new Node<Item>(item, first);

        size++;
    }

    public Item pop() {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow.");

        final Item item = first.item;

        first = first.next;

        size--;

        return item;
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder("[");
        for (Item item : this) {
            if (result.length() != 1)
                result.append(", ");
            result.append(item);
        }
        return result.append("]").toString();
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node<Item> nextNode = first;

        public boolean hasNext() {
            return nextNode != null;
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException("No more items in iteration.");

            final Item item = nextNode.item;

            nextNode = nextNode.next;

            return item;
        }

    }

    public static void main(final String[] arguments) {
        final LinkedStack<String> words = new LinkedStack<>();

        out.println("Adding 'First', 'Second', and 'Third' to stack…");
        words.push("First");
        words.push("Second");
        words.push("Third");

        out.println("The stack contains (top do bottom):");
        out.println(words);

        final LinkedStack<String> copyOfWords = new LinkedStack<>(words);

        out.println("The stack copy contains (top do bottom):");
        out.println(copyOfWords);
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