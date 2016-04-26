package pt.europeia.eda.piazza.experiments;

public class Utilities {

    public static void swap(final Object[] values, final int firstPosition,
            final int secondPosition) {
        final Object temporary = values[firstPosition];
        values[firstPosition] = values[secondPosition];
        values[secondPosition] = temporary;
    }

    public static <Value extends Comparable<? super Value>> boolean isLess(
            final Value first, final Value second) {
        return first.compareTo(second) < 0;
    }

    public static <Value extends Comparable<? super Value>> boolean isEqual(
            final Value first, final Value second) {
        return first.compareTo(second) == 0;
    }

    public static <Item extends Comparable<? super Item>> boolean isIncreasing(
            final Item[] values) {
        return isIncreasing(values, 0, values.length - 1);
    }

    public static <Item extends Comparable<? super Item>> boolean isIncreasing(
            final Item[] values, final int first, final int last) {
        for (int i = first + 1; i <= last; i++)
            if (isLess(values[i], values[i - 1]))
                return false;

        return true;
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