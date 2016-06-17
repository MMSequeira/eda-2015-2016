package pt.europeia.eda.exams.pipaf20160429t1000;

import static java.lang.System.out;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class SortTester {

    public static void main(final String[] arguments) {
        final int numberOfRepetions = 10000;

        for (int size = 1; size != 1 << 11; size <<= 1) {
            final double[] originalValues = randomDoubleArrayOf(size);
            final double[] sortedValues = originalValues.clone();
            Arrays.sort(sortedValues);

            for (int repetition = 0; repetition != numberOfRepetions; repetition++) {
                final double[] values = originalValues.clone();

//                Insertion1.sort(values);
                Insertion2.sort(values);

                if (!Arrays.equals(values, sortedValues)) {
                    out.println("Error (size = " + size + ", repetition = "
                            + repetition + "):");
                    out.println("\tWas:       " + Arrays.toString(originalValues));
                    out.println("\tShould be: " + Arrays.toString(sortedValues));
                    out.println("\tIs:        " + Arrays.toString(values));
                }
            }
        }
    }

    private static double[] randomDoubleArrayOf(final int size) {
        final double[] values = new double[size];

        for (int i = 0; i != values.length; i++)
            values[i] = Math.round(StdRandom.uniform() * 100.0) / 100.0;

        return values;
    }

}
