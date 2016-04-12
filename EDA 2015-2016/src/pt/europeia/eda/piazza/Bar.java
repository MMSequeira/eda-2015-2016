package pt.europeia.eda.piazza;

import static java.lang.System.out;

/**
 * A concrete class whose instances may be asked to foo.
 */
public class Bar extends Fooer {

    // Provide a method to the operation foo() abstractly declared in Fooer:
    @Override
    public void foo() {
        out.println("Foo!");
    }

    public static void main(final String[] arguments) {
        // Since a Bar is a Fooer (inheritance) and a Fooer is Fooable
        // (implementation), references of type Fooer or Fooable may hold
        // references to instances of Bar:
        final Bar bar = new Bar();
        final Fooer fooer = bar;
        final Fooable fooable = fooer;

        bar.foo();
        fooer.foo();
        fooable.foo();
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