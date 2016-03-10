package pt.europeia.eda.extra.session1;

import static java.lang.System.out;

/*
 * These are solutions to some of the CodingBat Java Warmup-1 exercises. 
 */
public class Warmup1 {

    /*
     * Given a non-empty string and an int n, return a new string where the char
     * at index n has been removed. The value of n will be a valid index of a
     * char in the original string (i.e. n will be in the range
     * 0..str.length()-1 inclusive).
     * 
     * missingChar("kitten", 1) → "ktten"
     * 
     * missinChar("kitten", 0) → "itten"
     * 
     * missingChar("kitten", 4) → "kittn"
     */
    public static String missingChar(final String str, final int n) {
        return str.substring(0, n) + str.substring(n + 1);

        // An alternative would be to store the first and second parts of the
        // result string in variables (or rather, to store *references* to these
        // strings):

        // final String firstPart = str.substring(0, n);
        // final String secondPart = str.substring(n + 1);
        //
        // return firstPart + secondPart;
    }

    /*
     * Given a string, return a new string where the first and last chars have
     * been exchanged.
     * 
     * frontBack("code") → "eodc"
     * 
     * frontBack("a") → "a"
     * 
     * frontBack("ab") → "ba"
     */
    public static String frontBack(final String str) {
        // Special cases are dealt with first:
        if (str.length() <= 1)
            return str;

        final char firstCharacter = str.charAt(0);
        final String middleOfStr = str.substring(1, str.length() - 1);
        final char lastCharacter = str.charAt(str.length() - 1);

        return lastCharacter + middleOfStr + firstCharacter;

        // A poorer alternative would be to store the first and last characters
        // as one character long strings:

        // final String firstCharacter = str.substring(0, 1);
        // final String middleOfStr = str.substring(1, str.length() - 1);
        // final String lastCharacter = str.substring(str.length() - 1);
        //
        // return lastCharacter + middleOfStr + firstCharacter;
    }

    /*
     * Given a string, we'll say that the front is the first 3 chars of the
     * string. If the string length is less than 3, the front is whatever is
     * there. Return a new string which is 3 copies of the front.
     * 
     * front3("Java") → "JavJavJav"
     * 
     * front3("Chocolate") → "ChoChoCho"
     * 
     * front3("abc") → "abcabcabc"
     */
    public static String front3(final String str) {
        // Special cases are dealt with first:
        if (str.length() <= 3)
            return str + str + str;

        final String firstThreeChars = str.substring(0, 3);

        return firstThreeChars + firstThreeChars + firstThreeChars;
    }

    /*
     * Given a string, take the last char and return a new string with the last
     * char added at the front and back, so "cat" yields "tcatt". The original
     * string will be length 1 or more.
     * 
     * backAround("cat") → "tcatt"
     * 
     * backAround("Hello") → "oHelloo"
     * 
     * backAround("a") → "aaa"
     */
    public static String backAround(final String str) {
        final char lastCharacter = str.charAt(str.length() - 1);

        return lastCharacter + str + lastCharacter;

        // A poorer alternative would be to store the last character
        // as a one character long string:

        // final String lastCharacter = str.substring(str.length() - 1);
        //
        // return lastCharacter + str + lastCharacter;
    }

    /*
     * Return true if the given non-negative number is a multiple of 3 or a
     * multiple of 5. Use the % "mod" operator -- see Introduction to Mod
     * 
     * or35(3) → true
     * 
     * or35(10) → true
     * 
     * or35(8) → false
     */
    public static boolean or35(final int n) {
        return n % 3 == 0 || n % 5 == 0;
    }

    /*
     * Given a string, take the first 2 chars and return the string with the 2
     * chars added at both the front and back, so "kitten" yields"kikittenki".
     * If the string length is less than 2, use whatever chars are there.
     * 
     * front22("kitten") → "kikittenki"
     * 
     * front22("Ha") → "HaHaHa"
     * 
     * front22("abc") → "ababcab"
     */
    public static String front22(final String str) {
        // Special cases are dealt with first:
        if (str.length() <= 2)
            return str + str + str;

        final String firstTwoCharacters = str.substring(0, 2);

        return firstTwoCharacters + str + firstTwoCharacters;
    }

    /*
     * Given a string, return true if the string starts with "hi" and false
     * otherwise.
     * 
     * startHi("hi there") → true
     * 
     * startHi("hi") → true
     * 
     * startHi("hello hi") → false
     */
    public static boolean startHi(final String str) {
        if (str.length() < 2)
            return false;

        return str.substring(0, 2).equals("hi");

        // A simpler alternative, using another method from the String class:

        // return str.startsWith("hi");
    }

    /*
     * An utility method for print results together with expected results.
     */
    private static void showResult(final Object result,
            final Object expectedResult) {
        out.println("\t" + result + " should be " + expectedResult);
    }

    public static void main(final String[] arguments) {
        out.println("missingChar():");
        showResult(missingChar("kitten", 1), "ktten");
        showResult(missingChar("kitten", 0), "itten");
        showResult(missingChar("kitten", 4), "kittn");

        out.println("frontBack():");
        showResult(frontBack("code"), "eodc");
        showResult(frontBack("a"), "a");
        showResult(frontBack("ab"), "ba");

        out.println("front3():");
        showResult(front3("Java"), "JavJavJav");
        showResult(front3("Chocolate"), "ChoChoCho");
        showResult(front3("abc"), "abcabcabc");

        out.println("backAround():");
        showResult(backAround("cat"), "tcatt");
        showResult(backAround("Hello"), "oHelloo");
        showResult(backAround("a"), "aaa");

        out.println("or35():");
        showResult(or35(3), true);
        showResult(or35(10), true);
        showResult(or35(8), false);

        out.println("front22():");
        showResult(front22("kitten"), "kikittenki");
        showResult(front22("Ha"), "HaHaHa");
        showResult(front22("abc"), "ababcab");

        out.println("startHi():");
        showResult(startHi("hi there"), true);
        showResult(startHi("hi"), true);
        showResult(startHi("hello hi"), false);
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