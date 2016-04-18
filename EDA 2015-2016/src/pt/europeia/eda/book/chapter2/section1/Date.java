package pt.europeia.eda.book.chapter2.section1;

// This should be seen as an example of implementing the Comparable
// interface only. As an example of possible representation of dates, it
// is *not* a good example. Date and time are notoriously hard to
// to design and implement right.
//
// See: https://docs.oracle.com/javase/tutorial/datetime/iso/legacy.html
public class Date implements Comparable<Date> {
    
    private final int year;
    private final int month;
    private final int day;

    public Date(final int year, final int month, final int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int compareTo(final Date other) {
        if (year < other.year)
            return -1;
        if (year > other.year)
            return +1;
        if (month < other.month)
            return -1;
        if (month > other.month)
            return +1;
        if (day < other.day)
            return -1;
        if (day > other.day)
            return +1;
        return 0;
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