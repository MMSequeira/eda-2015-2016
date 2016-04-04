package pt.europeia.eda.iga.session9;

import static java.lang.System.out;

import pt.europeia.eda.book.chapter1.section3.generic.FixedCapacityStack;

public class FixedCapacityStackTester {

    public static void main(final String[] arguments) {
        // Generics can be parametrized with reference types, such as String,
        // without any problem:
        final FixedCapacityStack<String> words = new FixedCapacityStack<String>(
                10);

        words.push("to");
        words.push("be");

        out.println(words.pop());
        out.println(words.pop());

        // It is not possible to use value types, such as int, as type arguments
        // when using generics:
        // FixedCapacityStack<int> numbers = new FixedCapacityStack<int>(10);

        // Try to remove the comment from the statement above an read carefully
        // the compilation error that results. Can you understand it? Cryptic,
        // right? The compiler is telling us that by adding dimensions, i.e.,
        // [], the type argument would be a reference type, and hence valid.

        // Instead of using value types, we may use the corresponding reference,
        // wrapper types:
        final FixedCapacityStack<Integer> numbers = new FixedCapacityStack<Integer>(
                10);

        // Since Java supports auto-boxing, these instructions work:
        numbers.push(10); // numbers.push(new Integer(10));
        numbers.push(20); // numbers.push(new Integer(20));

        int number1 = numbers.pop(); // = numbers.pop().intValue();
        int number2 = numbers.pop(); // = numbers.pop().intValue();

        out.println(number1);
        out.println(number2);
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