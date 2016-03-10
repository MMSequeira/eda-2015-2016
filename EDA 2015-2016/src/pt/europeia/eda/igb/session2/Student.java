package pt.europeia.eda.igb.session2;

/*
 * All classes extend some other class. If no superclass is indicated
 * explicitly, Java adds Object as the superclass.
 */
public class Student /* extends Object */ {

    public Student(final String firstName, final String lastName,
            final String number, final Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNumber() {
        return number;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return getFirstName() + " " + getLastName();
    }

    @Override
    public String toString() {
        return "Student [name = " + getName() + ", number = " + getNumber()
                + ", gender = " + getGender() + "]";
    }

    private String firstName;
    private String lastName;
    private String number;
    private Gender gender;
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