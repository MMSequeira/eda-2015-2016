package pt.europeia.eda.igb.session9;

import static java.lang.System.out;

import pt.europeia.eda.book.chapter1.section3.generic.LinkedStack;

// A few examples showing that value types (in Java the value types are
// also the primitive types) cannot be used as type arguments to generics.
public class CodeExamples {

    public static void main(final String[] arguments) {
        // Is is perfectly possible to pass String as type argument to a generic
        // stack, since String is a class and hence, in Java, a reference type:
        final LinkedStack<String> words = new LinkedStack<String>();

        words.push("to");
        words.push("be");
        words.push("or");

        out.println(words.pop());
        out.println(words.pop());
        out.println(words.pop());

        // If you uncomment this code, a compilation error occurs, since int is
        // a primitive/value type, and hence cannot be used as type argument to
        // a generic. The error produced is a bit cryptic: 'Syntax error, insert
        // "Dimensions" to complete ReferenceType'. The compiler is telling us
        // that adding "[]" (the "dimensions") to int would make the type
        // argument a reference type. Indeed, int[], an array of int, is a
        // reference type, but it is not what we need.
        // final LinkedStack<int> numbers = new LinkedStack<int>();

        // We may, however, use the wrapper class Integer, instead of int:
        final LinkedStack<Integer> numbers = new LinkedStack<Integer>();

        // Using the wrapper type seems to be a bit more troublesome, since we
        // apparently need explicitly to wrap (i.e., to box) and to unwrap
        // (e.g., to unbox) the int values into and from Integer instances:
        numbers.push(new Integer(10));
        numbers.push(new Integer(20));
        numbers.push(new Integer(30));

        int number1 = numbers.pop().intValue();
        int number2 = numbers.pop().intValue();
        int number3 = numbers.pop().intValue();

        out.println(number1);
        out.println(number2);
        out.println(number3);

        // But Java automaticaly boxes and unboxes primitive types into and from
        // corresponding wrapper class instances:
        numbers.push(10);
        numbers.push(20);
        numbers.push(30);

        number1 = numbers.pop();
        number2 = numbers.pop();
        number3 = numbers.pop();

        out.println(number1);
        out.println(number2);
        out.println(number3);
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