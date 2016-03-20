package pt.europeia.eda.piazza;

/**
 * The instances of any concrete class extending Fooer may be asked to foo.
 */
public abstract class Fooer implements Fooable {

    // This abstract class does not really implement Fooable.foo(); it merely
    // declares an abstract operation with the same signature, thus "abstractly
    // implementing" the operation:
    @Override
    public abstract void foo();
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