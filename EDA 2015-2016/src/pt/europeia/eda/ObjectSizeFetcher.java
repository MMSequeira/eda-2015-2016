package pt.europeia.eda;

import java.lang.instrument.Instrumentation;

public class ObjectSizeFetcher {
    private static Instrumentation instrumentation;

    public static void premain(final String arguments,
            final Instrumentation instrumentation) {
        ObjectSizeFetcher.instrumentation = instrumentation;
    }

    public static long sizeOf(final Object object) {
        return instrumentation.getObjectSize(object);
    }
}

/*
 * Based (with irrelevant changes) on http://bit.ly/1T0OQpt
 * 
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