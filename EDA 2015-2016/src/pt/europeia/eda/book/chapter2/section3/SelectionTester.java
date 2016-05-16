package pt.europeia.eda.book.chapter2.section3;

import static java.lang.System.out;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class SelectionTester {

    public static void main(final String[] arguments) {
        final int numberOfRepetions = 100;

        for (int size = 1; size != 1 << 11; size <<= 1) {
            final Double[] originalValues = randomDoubleArrayOf(size);
            final Double[] sortedValues = originalValues.clone();
            Arrays.sort(sortedValues);

            for (int repetition = 0; repetition != numberOfRepetions; repetition++) {
                for (int k = 0; k != originalValues.length; k++) {
                    final Double[] values = originalValues.clone();

                    final Double kthSmallest = Quick.select(values, k);

                    if (!kthSmallest.equals(sortedValues[k])) {
                        out.println("Error (size = " + size + ", repetition = "
                                + repetition + "):");
                        out.println("\tKth-smallest was:" + kthSmallest);
                        out.println("\tKth-smallest should be:  "
                                + sortedValues[k]);
                    }
                }
            }
        }
    }

    private static Double[] randomDoubleArrayOf(final int size) {
        final Double[] values = new Double[size];

        for (int i = 0; i != values.length; i++)
            values[i] = Math.round(StdRandom.uniform() * 100.0) / 100.0;

        return values;
    }

}
