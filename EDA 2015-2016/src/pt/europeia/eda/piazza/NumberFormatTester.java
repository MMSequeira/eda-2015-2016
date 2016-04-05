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
        // This pattern leads to numbers being formatted with two decimal
        // places, using rounding (DecimalFormat uses "half even" rounding by
        // default):
        DecimalFormat formatter = new DecimalFormat("0.00");

        // Since 4.445 is equally close to 4.44 and to 4.45, it is rounded so
        // the next digit is even (down, in this case). Hence, the expected
        // result is "4.44":
        out.println(formatter.format(4.445) + " (4.445 → 4.44 expected)");

        // Since 4.446 is closer to 4.45 than to 4.44, it is rounded up. Hence,
        // the expected result is "4.45":
        out.println(formatter.format(4.446) + " (4.446 → 4.45 expected)");

        // Since 4.4445 is closer to 4.44 than to 4.45, it is rounded down.
        // Hence, the expected result is "4.44":
        out.println(formatter.format(4.4445) + " (4.4445 → 4.44 expected)");

        // Since 4.4446 is closer to 4.44 than to 4.45, it is rounded down.
        // Hence, the expected result is "4.44":
        out.println(formatter.format(4.4446) + " (4.4446 → 4.44 expected)");

        // Since 4.4415 is equally close to 4.441 and to 4.442, it is rounded so
        // the next digit is even (up, in this case). Hence, the expected result
        // is "4.442":
        out.println(new DecimalFormat("0.000").format(4.4415)
                + " (4.4415 → 4.442 expected)");

        // Since 4.4416 is closer to 4.442 than to 4.441, it is rounded up.
        // Hence, the expected result is "4.442":
        out.println(new DecimalFormat("0.000").format(4.4416)
                + " (4.4416 → 4.442 expected)");

        // Since 4.4445 is equally close to 4.444 and to 4.445, it is
        // rounded so the next digit is even (down, in this case). Hence, the
        // expected result is "4.444":
        out.println(new DecimalFormat("0.000").format(4.4445)
                + " (4.4445 → 4.444 expected)");

        // Since 4.4446 is closer to 4.445 and to 4.444, it is rounded up.
        // Hence, the expected result is "4.445":
        out.println(new DecimalFormat("0.000").format(4.4446)
                + " (4.4446 → 4.445 expected)");

        // The truth is revealed by running the code below. As
        // can be seen, the literal 4.445 is actually stored as a a larger
        // number. On the other hand, the the literals 4.4415 and 4.4445 are
        // actually stored as smaller numbers and hence, when rounded to three
        // decimal places, they are actually rounded down:
        out.println(new BigDecimal(4.445));
        out.println(new BigDecimal(4.4415));
        out.println(new BigDecimal(4.4445));

        // These numbers are represented exactly, and hence rounding occurs as
        // expected:
        out.println(new DecimalFormat("0.00").format(4.125));
        out.println(new DecimalFormat("0.00").format(4.375));
        out.printf("%.2f\n", 4.125);
        out.printf("%.2f\n", 4.375);
        out.println(new BigDecimal(4.125));
        out.println(new BigDecimal(4.375));

        // The initial case seemed to work well only because the actual number
        // store was larger, and hence it was rounded up, as expected:
        // out.println(new BigDecimal(4.445));

        // Please remember: floats and doubles are store using a base 2
        // representation. Numbers with a finite number of digits after the
        // point in base 10 can actually have an infinite number of digits after
        // the point in base 2. Since floats and double store only a finite
        // number of digits most decimal literals are approximated, rather than
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