package pt.europeia.eda.eisiwm.session2;

public class CodeExamples {

    @SuppressWarnings("unused")
    public static void main(final String[] arguments) {
        /*
         * The type int is a value type (in Java all, and only, primitive types
         * are value types). Hence, variables declared to be int store directly
         * an integer value. They do not store a reference to an int object or
         * instance created with the new operator, and thus cannot be
         * initialized with or assigned the null value, which is valid only for
         * variables of reference types, such as classes or arrays.
         */
        // int i = null;

        /*
         * The type Integer is a wrapper class. It wraps an int value, storing
         * it in a Integer instance. Since Integer is a class, it is a reference
         * type. Hence, it can be used as any other reference type. Since all
         * classes in Java directly or indirectly derive from Object, Integer
         * instances may be treated as any other object.
         */
        // Constructs a new Integer wrapping int value 0 an stores its reference
        // in variable integer. Notice that integer does *not* store the
        // Integer, just a reference to it.
        Integer integer = new Integer(0);

        // It is possible to obtain the int value stored in a Integer wrapper:
        int i = integer.intValue();

        // Since Java supports auto-boxing, this may be done more simply by
        // using the Integer where an int is expected and vice-versa:
        i = integer;
        integer = i;

        // Lack of explicit initialization only leads to implicit default
        // initialization for non-local variables:
        int a;

        // Using an uninitialized local variable is an error:
        // System.out.println(a);
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