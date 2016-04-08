package pt.europeia.eda.igb.session10;

import static java.lang.System.out;

public class CodeExamples {

    // This recursive implementation of the factorial is missing the base case.
    // This means it is an infinite recursion. Or rather, it would be, if the
    // JVM used an infinite stack. Since each (recursive) call takes some stack
    // space and the stack is limited, any call to this function will result in
    // a StackOverflowError (which, being a subclass of Error, should not be
    // caught). Try it.
    public static int factorial(final int n) {
        /*-
        if (n == 0)
            return 1;
        */

        return n * factorial(n - 1);
    }

    public static void main(final String[] arguments) {
        out.println(factorial(5));
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