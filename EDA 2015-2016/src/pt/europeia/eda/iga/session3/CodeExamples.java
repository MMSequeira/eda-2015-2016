package pt.europeia.eda.iga.session3;

// Just as classes may be imported from packages, class members
// (static members) may be imported from package-classes (or from regular
// classes) using import static:

import static java.lang.Math.PI;
import static java.lang.System.out;

// Regular import of a (generic) class from a package:

import java.util.ArrayList;

public class CodeExamples {

    public static void main(final String[] arguments) {
        // Now we may use out and PI without prefixing them with the package
        // class they belong to:
        out.println(PI);

        // Now we may use ArrayList without prefixing it with the package
        // it belongs to:
        ArrayList<String> list = new ArrayList<String>();
        
        // Avoids warnings:
        out.println(list);
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