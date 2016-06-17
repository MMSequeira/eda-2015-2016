package pt.europeia.eda.exams.pipaf20160429t1000;

import static java.lang.System.out;

public final class Quick3Ways {

    private Quick3Ways() {
        throw new RuntimeException("Attempt to instantiate package-class");
    }

    public static void sort(final double[] values) {
        sort(values, 0, values.length - 1);
    }

    private static void sort(final double[] values, final int first,
            final int last) {
        if (last <= first)
            return;

        int lowest = first;
        int greatest = last;

        int i = first + 1;

        final double pivot = values[first];

        while (i <= greatest) {
            final int comparison = compare(values[i], pivot);

            if (comparison < 0) {
                swap(values, lowest, i);
                lowest++;
                i++;
            } else if (comparison > 0) {
                swap(values, i, greatest);
                greatest--;
            } else
                i++;
        }

        sort(values, first, lowest - 1);
        sort(values, greatest + 1, last);
    }

    private static int compare(final double first, final double second) {
        if (first < second)
            return -1;
        if (first > second)
            return 1;
        return 0;
    }

    private static void swap(final double[] values, final int i, final int j) {
        final double temporary = values[i];
        values[i] = values[j];
        values[j] = temporary;
    }

    private static void show(final double[] values) {
        for (double value : values)
            out.println(value);
    }

    public static void main(final String[] arguments) {
        final double[] values = {10.0, 60.0, 20.0, 50.0, 30.0, 70.0, 40.0};
        
        Quick3Ways.sort(values);
        
        show(values);
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