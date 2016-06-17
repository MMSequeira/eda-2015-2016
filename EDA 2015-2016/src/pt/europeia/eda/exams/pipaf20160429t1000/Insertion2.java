package pt.europeia.eda.exams.pipaf20160429t1000;

public final class Insertion2 {

    private Insertion2() {
        throw new RuntimeException("Attempt to instantiate package-class");
    }

    public static void sort(final double[] values) {
        for (int n = 1; n < values.length; n++) {
            final double value = values[n];
            final int i = indexOfFirstLarger(values, 0, n - 1, value);
            int j = n;
            for (; j != i; j--)
                values[j] = values[j - 1];
            values[j] = value;
        }
    }

    private static int indexOfFirstLarger(final double[] values, int first, int last,
            final double value) {
        while (first <= last) {
            final int middle = first + (last - first) / 2;

            if (value < values[middle])
                last = middle - 1;
            else
                first = middle + 1;
        }
        return first;
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