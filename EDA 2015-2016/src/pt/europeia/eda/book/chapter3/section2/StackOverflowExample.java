package pt.europeia.eda.book.chapter3.section2;

import static java.lang.System.out;

public class StackOverflowExample {

    // Basic BST are vulnerable. If keys are inserted in non-random order, the
    // tree degenerates. This may lead to problems using recursive methods,
    // since stack overflows become likely.
    public static void main(final String[] arguments) {
        BstOrderedTable<Integer, Integer> table = new BstOrderedTable<Integer, Integer>();

        for (int i = 0; i != 100000; i++)
            table.put(i, i);

        out.println(table.size());
    }

}

/*
 * Copyright 2016, Manuel Menezes de Sequeira.
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
 */