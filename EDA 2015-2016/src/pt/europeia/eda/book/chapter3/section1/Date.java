package pt.europeia.eda.book.chapter3.section1;

import static java.lang.System.out;

// This Date class is *not* a good example of how to deal with dates. It
// is nice, though, to show how to implement the compareTo() and equals()
// methods.
public final class Date implements Comparable<Date> {
    private final int year;
    private final int month;
    private final int day;

    public Date(final int year, final int month, final int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // The equals() method must override Object.equals(), which has a single
    // Object parameter. If the parameter is defined to have type Date, no
    // overriding occurs. Try the main() method below. Watch the result. Comment
    // out "Object" below, uncomment "Date", and comment out "@Overrides". Try
    // to run the main() method again. Notice the difference.
    @Override
    public boolean equals(final Object /* Date */ other) {
        if (other == this)
            return true;

        if (other == null)
            return false;

        if (other.getClass() != getClass())
            return false;

        final Date that = (Date) other;
        if (day != that.day)
            return false;
        if (month != that.month)
            return false;
        if (year != that.year)
            return false;
        return true;
    }

    @Override
    public int compareTo(final Date that) {
        if (year != that.year)
            return year - that.year;
        if (month != that.month)
            return month - that.month;
        return day - that.month;
    }

    public static void main(final String[] arguments) {
        final Date date1 = new Date(2016, 4, 15);
        final Date date2 = new Date(2016, 4, 15);

        out.println(date1 == date2);
        out.println(date1.equals(date2));

        final Object object1 = date1;
        final Object object2 = date2;

        out.println(object1 == object2);
        out.println(object1.equals(object2));
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