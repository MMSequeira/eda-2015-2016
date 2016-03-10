package pt.europeia.eda.eisiwm.session2;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Scanner;

/*
 * Solutions to the diagnostic problems.
 */
public class Diagnostics {

    // Print all values from 1 to 10, inclusive, using a loop:
    public static void exercise1() {
        for (int i = 1; i < 11; i++)
            out.println(i);
    }

    // Print all values from 10 to 1, inclusive, using a loop:
    public static void exercise2() {
        for (int i = 10; i > 0; i--)
            out.println(i);
    }

    // Store a sequence of integers, ask a number to the user and report whether
    // the input number is in the sequence:
    public static void exercise3() {
        final int[] numbers = { 3, -5, 65, 32, 0, 100, 40, 20, -10 };

        final Scanner input = new Scanner(in);

        out.print("Insert number to find: ");

        final int numberToSearch = input.nextInt();

        input.close();

        // This should actually be done in an search method. Notice the
        // declaration of i outside the loop, allowing us to use its value after
        // the loop ends:
        int i = 0;
        while (i != numbers.length && numbers[i] != numberToSearch)
            i++;

        // These are alternative solutions to the problem:
        /*-
        int i = 0;
        while (i != numbers.length) {
            if (numbers[i] == numberToSearch)
                break;
            i++;
        }
        */
        /*-
        int i;
        for (i = 0; i != numbers.length; i++)
            if (numbers[i] == numberToSearch)
                break;
        */
        
        // The loop may end because the array was exhausted or because the
        // number was found. This condition allows us to distinguish the two
        // cases:
        if (i == numbers.length)
            out.println("Number not found.");
        else
            out.println("Number found in position " + i + ".");
    }

    // Exercise 4 will be addressed later. It involves using binary search.

    public static void exercise5() {
        final Student xistoXimenes = new Student("Xisto", "Ximenes", "50012345",
                Gender.Male);

        out.println(xistoXimenes);
    }

    public static void main(final String[] arguments) {
        out.println("Exercise 1:");
        exercise1();

        out.println("Exercise 2:");
        exercise2();

        out.println("Exercise 3:");
        exercise3();

        out.println("Exercise 5:");
        exercise5();
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