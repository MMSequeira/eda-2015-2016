package pt.europeia.eda.piazza;

import static java.lang.System.out;

// import java.math.BigDecimal;

import java.text.DecimalFormat;

public class NumberFormatTester {

    // This is just a test of the rounding performed by DecimalFormat formatting
    // patterns. Please read the DecimalFormat documentation, which warns
    // against directly creating instances, instead of using NumberFormat
    // factory methods.
    public static void main(final String[] arguments) {
        // This pattern leads to numbers being formatted with two decimal
        // places, using rounding:
        DecimalFormat formatter = new DecimalFormat("0.00");

        // Since 4.445 is equally close to 4.44 and to 4.45, it is rounded up
        // (by
        // convention). Since 4.446 is closer to 4.45 than to 4.44, it is also
        // rounded up. Hence, the result is "4.45" in both cases:
        out.println(formatter.format(4.445));
        out.println(formatter.format(4.446));

        // Since 4.4445 is closer to 4.44 than to 4.45, it is rounded down.
        // Since
        // 4.4446 is closer to 4.44 than to 4.45, it is also rounded down.
        // Hence, the result is "4.44" in both cases:
        out.println(formatter.format(4.4445));
        out.println(formatter.format(4.4446));

        // This case is more interesting. Since 4.4445 is equally close to 4.444
        // and to 4.445, shouldn't it be rounded up to 4.445, just as 4.4446 is?
        // Why isn't it?
        out.println(new DecimalFormat("0.000").format(4.4445));
        out.println(new DecimalFormat("0.000").format(4.4446));

        // The truth is revealed by uncommenting and running the code below. As
        // can be seen, the literal 4.4445 is actually stored as a number which
        // is smaller. Hence, when rounded to three decimal places, it is
        // actually rounded down:
        // out.println(new BigDecimal(4.4445));

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