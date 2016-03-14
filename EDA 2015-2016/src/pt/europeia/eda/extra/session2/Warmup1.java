package pt.europeia.eda.extra.session2;

import static java.lang.System.out;

/*
 * These are solutions to some of the CodingBat Java Warmup-1 exercises. 
 */
public class Warmup1 {

    /*
     * Given a string, return a string made of the first 2 chars (if present),
     * however include first char only if it is 'o' and include the second only
     * if it is 'z', so "ozymandias" yields "oz".
     * 
     * startOz("ozymandias") → "oz"
     * 
     * startOz("bzoo") → "z"
     * 
     * startOz("oxx") → "o"
     */
    public static String startOz(final String str) {
        return ((str.length() >= 1 && str.charAt(0) == 'o') ? "o" : "")
                + ((str.length() >= 2 && str.charAt(1) == 'z') ? "z" : "");

        // This solution builds each part of the solution first, using the ?:
        // operator, then returns the complete solution by concatenating these
        // two parts:
        /*-
        final String firstPart = (str.length() >= 1 && str.charAt(0) == 'o')
                ? "o" : "";
        final String secondPart = (str.length() >= 2 && str.charAt(1) == 'z')
                ? "z" : "";
                
        return firstPart + secondPart;
        */
        
        // This solution builds each part of the solution first, using regular
        // ifs, then returns the complete solution by concatenating these two
        // parts:
        /*-
        final String firstPart;
        if (str.length() >= 1 && str.charAt(0) == 'o')
            firstPart = "o";
        else
            firstPart = "";
        
        final String secondPart;
        if (str.length() >= 2 && str.charAt(1) == 'z')
            secondPart = "z";
        else
            secondPart = "";
        
        return firstPart + secondPart;
        */
    }

    /*
     * An utility method for printing results together with expected results.
     */
    private static void showResult(final Object result,
            final Object expectedResult) {
        out.println("\t" + result + " should be " + expectedResult);
    }

    public static void main(final String[] arguments) {
        out.println("front22():");
        showResult(startOz("ozymandias"), "oz");
        showResult(startOz("bzoo"), "z");
        showResult(startOz("oxx"), "o");
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