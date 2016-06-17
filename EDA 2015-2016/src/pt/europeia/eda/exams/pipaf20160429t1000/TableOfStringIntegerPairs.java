package pt.europeia.eda.exams.pipaf20160429t1000;

import static java.lang.System.out;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;

public class TableOfStringIntegerPairs {

    private Node root;

    private static class Node {

        private final String key;
        private Integer value;
        private Node left = null;
        private Node right = null;

        public Node(final String key, final Integer value) {
            this.key = key;
            this.value = value;
        }

    }

    public TableOfStringIntegerPairs() {
        root = null;
    }

    public int size() {
        return sizeOf(root);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(final String key) {
        return valueFor(key) != null;
    }

    public Integer valueFor(final String key) {
        return valueFor(key, root);
    }

    public Iterable<String> keys() {
        return keysInRange(minimum(), maximum());
    }

    public void put(final String key, final Integer value) {
        if (value == null) {
            delete(key);
            return;
        }

        root = putIn(key, value, root);
    }

    public void delete(final String key) {
        root = deleteFrom(key, root);
    }

    public int rankOf(final String key) {
        return rankOf(key, root);
    }

    public String minimum() {
        if (isEmpty())
            return null;

        return minimumNodeOf(root).key;
    }

    public String maximum() {
        if (isEmpty())
            return null;

        return maximumNodeOf(root).key;
    }

    public String keyWithRank(final int rank) {
        if (rank < 0 || rank >= size())
            return null;

        final Node nodeWithRank = nodeWithRankIn(rank, root);

        return nodeWithRank.key;
    }

    public String floorOf(final String key) {
        final Node floorNode = floorNodeOf(key, root);

        if (floorNode == null)
            return null;

        return floorNode.key;
    }

    public String ceilingOf(final String key) {
        Node ceilingNode = ceilingNodeOf(key, root);

        if (ceilingNode == null)
            return null;

        return ceilingNode.key;
    }

    public int sizeOfRange(final String low, final String high) {
        if (low.compareTo(high) > 0)
            return 0;

        if (contains(high))
            return rankOf(high) - rankOf(low) + 1;

        return rankOf(high) - rankOf(low);
    }

    public Iterable<String> keysInRange(final String low, final String high) {
        Queue<String> keys = new ArrayDeque<String>();

        enqueueKeysInRange(keys, low, high, root);

        return keys;
    }

    public Iterable<String> keysInLevelOrder() {
        Queue<String> keys = new ArrayDeque<String>();

        Queue<Node> nodes = new ArrayDeque<Node>();

        nodes.add(root);
        while (!nodes.isEmpty()) {
            final Node node = nodes.remove();

            if (node == null)
                continue;

            keys.add(node.key);

            nodes.add(node.left);
            nodes.add(node.right);
        }
        return keys;
    }

    public void deleteMinimum() {
        if (isEmpty())
            throw new NoSuchElementException("Symbol table underflow");

        root = deleteMinimumOf(root);
    }

    public void deleteMaximum() {
        if (isEmpty())
            throw new NoSuchElementException("Symbol table underflow");

        root = deleteMaximumOf(root);
    }

    private int sizeOf(final Node tree) {
        if (tree == null)
            return 0;

        return 1 + sizeOf(tree.left) + sizeOf(tree.right);
    }

    private Integer valueFor(final String key, final Node tree) {
        if (tree == null)
            return null;

        final int comparison = key.compareTo(tree.key);

        if (comparison < 0)
            return valueFor(key, tree.left);
        if (comparison > 0)
            return valueFor(key, tree.right);

        return tree.value;
    }

    private Node putIn(final String key, final Integer value, final Node tree) {
        if (tree == null)
            return new Node(key, value);

        final int comparison = key.compareTo(tree.key);

        if (comparison < 0)
            tree.left = putIn(key, value, tree.left);
        else if (comparison > 0)
            tree.right = putIn(key, value, tree.right);
        else
            tree.value = value;

        return tree;
    }

    private Node deleteFrom(final String key, Node tree) {
        if (tree == null)
            return null;

        final int comparison = key.compareTo(tree.key);

        if (comparison < 0)
            tree.left = deleteFrom(key, tree.left);
        else if (comparison > 0)
            tree.right = deleteFrom(key, tree.right);
        else {
            if (tree.right == null)
                return tree.left;
            if (tree.left == null)
                return tree.right;

            final Node originalTree = tree;

            tree = minimumNodeOf(originalTree.right);
            tree.right = deleteMinimumOf(originalTree.right);
            tree.left = originalTree.left;
        }

        return tree;
    }

    private int rankOf(final String key, final Node tree) {
        if (tree == null)
            return 0;

        final int comparison = key.compareTo(tree.key);

        if (comparison < 0)
            return rankOf(key, tree.left);

        if (comparison > 0)
            return 1 + sizeOf(tree.left) + rankOf(key, tree.right);

        return sizeOf(tree.left);
    }

    private Node minimumNodeOf(final Node tree) {
        if (tree.left == null)
            return tree;

        return minimumNodeOf(tree.left);
    }

    private Node maximumNodeOf(final Node tree) {
        if (tree.right == null)
            return tree;

        return maximumNodeOf(tree.right);
    }

    private Node nodeWithRankIn(final int rank, final Node tree) {
        if (tree == null)
            return null;

        final int rankOfTreeRoot = sizeOf(tree.left);

        if (rankOfTreeRoot > rank)
            return nodeWithRankIn(rank, tree.left);

        if (rankOfTreeRoot < rank)
            return nodeWithRankIn(rank - rankOfTreeRoot - 1, tree.right);

        return tree;
    }

    private Node floorNodeOf(final String key, final Node tree) {
        if (tree == null)
            return null;

        final int comparison = key.compareTo(tree.key);

        if (comparison == 0)
            return tree;

        if (comparison < 0)
            return floorNodeOf(key, tree.left);

        final Node floorNode = floorNodeOf(key, tree.right);

        if (floorNode != null)
            return floorNode;

        return tree;
    }

    private Node ceilingNodeOf(final String key, final Node tree) {
        if (tree == null)
            return null;

        final int comparison = key.compareTo(tree.key);

        if (comparison == 0)
            return tree;

        if (comparison > 0)
            return ceilingNodeOf(key, tree.right);

        final Node ceilingNode = ceilingNodeOf(key, tree.left);

        if (ceilingNode != null)
            return ceilingNode;

        return tree;
    }

    private void enqueueKeysInRange(final Queue<String> keys, final String low,
            final String high, final Node tree) {
        if (tree == null)
            return;

        final int comparisonWithLow = low.compareTo(tree.key);
        final int comparisonWithHigh = high.compareTo(tree.key);

        if (comparisonWithLow < 0)
            enqueueKeysInRange(keys, low, high, tree.left);

        if (comparisonWithLow <= 0 && comparisonWithHigh >= 0)
            keys.add(tree.key);

        if (comparisonWithHigh > 0)
            enqueueKeysInRange(keys, low, high, tree.right);
    }

    private Node deleteMinimumOf(final Node tree) {
        if (tree.left == null)
            return tree.right;

        tree.left = deleteMinimumOf(tree.left);

        return tree;
    }

    private Node deleteMaximumOf(final Node tree) {
        if (tree.right == null)
            return tree.left;

        tree.right = deleteMaximumOf(tree.right);

        return tree;
    }

    private int height() {
        return heightOf(root);
    }

    private int heightOf(final Node tree) {
        if (tree == null)
            return -1;

        return 1 + Math.max(heightOf(tree.left), heightOf(tree.right));
    }

    private boolean isHeightBalanced() {
        return isHeightBalanced(root);
    }
    
    private boolean isHeightBalanced(final Node tree) {
        if (tree == null)
            return true;
        
        if (Math.abs(heightOf(tree.left) - heightOf(tree.right)) > 1)
            return false;
        
        return isHeightBalanced(tree.left) && isHeightBalanced(tree.right);
    }
    
    public static void main(final String[] arguments) {
        final TableOfStringIntegerPairs index = new TableOfStringIntegerPairs();

        index.put("B", 0);
        index.put("A", 0);
        index.put("D", 0);
        index.put("E", 0);
        index.put("C", 0);
        index.put("F", 0);
//        index.put("AA", 0);
//        index.put("AAA", 0);
        
        out.println(index.height());
        out.println(index.isHeightBalanced());
    }

}

/*
 * Copyright 2015, Robert Sedgewick and Kevin Wayne.
 * 
 * Copyright 2015, Manuel Menezes de Sequeira.
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