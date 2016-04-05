package pt.europeia.eda.piazza;

import static java.lang.System.out;

import java.math.BigDecimal;

import java.text.DecimalFormat;

public class NumberFormatTester {

    // This is just a test of the rounding performed by DecimalFormat formatting
    // patterns. Please read the DecimalFormat documentation, which warns
    // against directly creating instances, instead of using NumberFormat
    // factory methods.
    public static void main(final String[] arguments) {
        // DecimalFormat uses "half even" rounding by default. That is, is case
        // of a tie, the number if rounded so that the last digit is even.

        out.println("Rounding to two decimal places:");

        final DecimalFormat f2 = new DecimalFormat("0.00");

        out.println("\t" + f2.format(4.125) + " (4.125 → 4.12 got)");
        out.println("\t" + f2.format(4.375) + " (4.375 → 4.38 got)");
        out.println("\t" + f2.format(4.445) + " (4.445 → 4.44 expected)");
        out.println("\t" + f2.format(4.446) + " (4.446 → 4.45 got)");
        out.println("\t" + f2.format(4.4445) + " (4.4445 → 4.44 got)");
        out.println("\t" + f2.format(4.4446) + " (4.4446 → 4.44 got)");

        out.println("Rounding to three decimal places:");

        final DecimalFormat f3 = new DecimalFormat("0.000");

        out.println("\t" + f3.format(4.4415) + " (4.4415 → 4.442 expected)");
        out.println("\t" + f3.format(4.4416) + " (4.4416 → 4.442 got)");
        out.println("\t" + f3.format(4.4445) + " (4.4445 → 4.444 got)");
        out.println("\t" + f3.format(4.4446) + " (4.4446 → 4.445 got)");

        out.println("Numbers with ties revealed:");

        // A hint to the unexpected results in case of apparent ties is given by
        // running the code below. As can be seen, the literal 4.445 is actually
        // stored as a a larger number. On the other hand, the the literals
        // 4.4415 and 4.4445 are actually stored as smaller numbers and hence,
        // when rounded to three decimal places, they are actually rounded down.
        // That is, these ties are really apparent only:
        out.println("\t4.445 as BigDecimal is " + new BigDecimal(4.445));
        out.println("\t4.4415 as BigDecimal is " + new BigDecimal(4.4415));
        out.println("\t4.4445 as BigDecimal is " + new BigDecimal(4.4445));

        // The other ties occur with numbers that are represented exactly, and
        // hence rounding occurs as expected. These are real ties:
        out.println("\t4.125 as BigDecimal is " + new BigDecimal(4.125));
        out.println("\t4.375 as BigDecimal is " + new BigDecimal(4.375));

        // Please remember: floats and doubles are stored using a base 2
        // representation. Numbers with a finite number of digits after the
        // point in base 10 can actually have an infinite number of digits after
        // the point in base 2. Since floats and double store only a finite
        // number of digits, most decimal literals are approximated, rather than
        // represented exactly.
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