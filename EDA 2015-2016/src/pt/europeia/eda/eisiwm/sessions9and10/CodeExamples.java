package pt.europeia.eda.eisiwm.sessions9and10;

import static java.lang.System.out;

import java.util.ArrayList;

public class CodeExamples {

    public static void main(final String[] arguments) {
        // It is possible to use reference types, such as classes, as type
        // arguments when using generics:
        final ArrayList<String> words = new ArrayList<String>();
        words.add("Hello world");
        out.println(words);

        // It is not possible to use value types, such as int, as type arguments
        // when using generics:
        // final ArrayList<int> numbers = new ArrayList<int>();

        // Try to remove the comment from the statement above an read carefully
        // the compilation error that results. Can you understand it? Cryptic,
        // right? The compiler is telling us that by adding dimensions, i.e.,
        // [], the type argument would be a reference type, and hence valid.

        // This version works, but not as we would like, since it declares and
        // instantiates an ArrayList of arrays of int:
        final ArrayList<int[]> arrays = new ArrayList<int[]>();
        arrays.add(new int[] { 1, 2, 4 });
        out.println(arrays);

        // Instead of using value types, we may use the corresponding reference,
        // wrapper types:
        final ArrayList<Integer> numbers = new ArrayList<Integer>();

        // Since Java supports auto-boxing, this instruction:
        numbers.add(10);
        // is (almost) equivalent to:
        numbers.add(new Integer(10));
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