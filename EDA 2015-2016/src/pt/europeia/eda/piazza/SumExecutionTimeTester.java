package pt.europeia.eda.piazza;

import static java.lang.System.out;

import pt.europeia.eda.Stopwatch;

import java.util.ArrayList;

/**
 * A simple class/program for obtaining experimentally the execution times of a
 * method summing all integers from 1 to different limits. This may help you
 * devise your own experiments in other cases, but it is *not* intended has a
 * basis for your own code, however. You should study this code carefully and
 * apply the insights gained to your own code. This code is not intended to be
 * in any way complete or to cover all interesting cases. Try to run these
 * tests. Copy the results to «Data» in http://gnuplot.respawned.com/. Then copy
 * the following Gnuplot script to «Plot script»:
 */
/*-
set terminal svg size 800,600 enhanced fname 'arial'  fsize 10 butt solid
set output 'out.svg'
set key inside bottom right
set xlabel 'sum limit'
set ylabel 'time (s)'
set y2label 'repetitions'
set title 'Execution times of sum of integers from 1 to limit'
set logscale x 2
set logscale y 10
set logscale y2 10
set grid
set xtics 2 rotate by 90 right format '%.0f'
set y2tics format '%g'
plot  "data.txt" using 1:2 title 'times' with linespoints, "data.txt" using 1:3 title 'number of repetitions' axes x1y2
 */
public class SumExecutionTimeTester {
    // A time budget is established per experiment. Each experiment is repeated
    // as many times as necessary to expend this budget. That is, each
    // experiment is repeated until the total time spent repeating it exceeds
    // the budget.
    public static final double timeBudgetPerExperiment = 1.0 /* seconds */;

    // Small execution times are very "noisy", since the System.nanoTime()
    // method does not have sufficient precision to measure them. In some
    // systems, smaller execution times may even be measured as 0.0! Hence, in
    // many cases it is preferable to perform a run of contiguous repetitions of
    // an experiment, instead of a single experiment. The total
    // execution time of that run of contiguous repetitions is measured. Then,
    // the execution time of a single experiment is estimated as the average
    // execution time, that is, the total execution time of the contiguous
    // repetitions divided by the number of contiguous repetitions of the
    // experiment performed. Instead of using always the same number of
    // contiguous repetitions, however, it is preferable to establish the
    // minimum
    // duration of a run to value which is clearly long enough for
    // System.nanoTime() to measure with acceptable accuracy.
    public static final double minimumTimePerContiguousRepetitions = 1e-5 /* seconds */;

    // A simple, inefficient way to calculate the median of the values in an
    // ArrayList:
    public static double medianOf(final ArrayList<Double> values) {
        final int size = values.size();

        values.sort(null);

        if (size % 2 == 0)
            return (values.get(size / 2 - 1) + values.get(size / 2)) / 2.0;
        else
            return values.get(size / 2);
    }

    // The method whose execution times are wanted:
    public static long sumFrom1To(final int limit) {
        long sum = 0;
        for (int i = 1; i <= limit; i++)
            sum += i;
        return sum;
    }

    // Used to store the results of the sums, so that the Java compiler does not
    // optimize away our calls to sumFrom1To() (this variable is used when
    // showing the experimental results, so we don't get warnings
    // about unused variables):
    private static long sum;

    // Estimate the number of contiguous repetitions to perform for a given
    // limit of the numbers to sum in the experiment:
    public static int contiguousRepetitionsFor(final int limit) {
        final Stopwatch stopwatch = new Stopwatch();
        int contiguousRepetitions = 0;
        do {
            sum = sumFrom1To(limit);
            contiguousRepetitions++;
        } while (stopwatch.elapsedTime() < minimumTimePerContiguousRepetitions);

        // The loop stops when the minimum time per contiguous repetitions is
        // reached. For longer experiments, this will mostly turn out to be one,
        // which is what we would expect, since contiguous repetitions are
        // useful only for small execution times.

        return contiguousRepetitions;
    }

    // Performs a run of contiguous repetitions of an experiment to obtain the
    // execution time of the method to calculate the sum of the integers from 1
    // to a given limit. The number of contiguous experiments is also passed as
    // argument.
    public static double executionTimeFor(final int limit,
            final int contiguousRepetitions) {
        final Stopwatch stopwatch = new Stopwatch();
        for (int i = 0; i != contiguousRepetitions; i++)
            sum = sumFrom1To(limit);
        return stopwatch.elapsedTime() / contiguousRepetitions;
    }

    // Performs experiments to obtain a sequence of estimates of the execution
    // time of the method to calculate the sum of the integers from 1
    // to a given limit. The number of experiments to performed is not fixed.
    // Rather, a time budget is used and the experiments are repeated until the
    // budged is spent. The sequence of the execution times obtained is then
    // used to calculate the median execution time, which is a reasonably robust
    // statistic. The results are shown, except if this is a warm up run.
    public static void performExperimentsFor(final int limit,
            final boolean isWarmup) {
        final ArrayList<Double> executionTimes = new ArrayList<Double>();
        final Stopwatch stopwatch = new Stopwatch();
        final int contiguousRepetitions = contiguousRepetitionsFor(limit);
        long repetitions = 0;
        do {
            executionTimes.add(executionTimeFor(limit, contiguousRepetitions));
            repetitions++;
        } while (stopwatch.elapsedTime() < timeBudgetPerExperiment);

        final double median = medianOf(executionTimes);

        if (!isWarmup)
            out.println(
                    limit + "\t" + median + "\t" + repetitions + "\t" + sum);
        /*-
        out.println("Sum from 1 to " + limit + " = " + sum + " [" + median
                + "s median time based on " + repetitions
                + " repetitions of " + contiguousRepetitions
                + " contiguous repetitions]");
        */
    }

    public static void main(final String[] arguments)
            throws InterruptedException {
        // The experiments are run for limits of the sums which increase
        // geometrically, through the powers of 2:

        // Warm up (this attempts to force the JIT compiler to do its work
        // before the experiments actually begin):
        for (int exponent = 0, limit = 1; exponent != 8; exponent++, limit *= 2)
            performExperimentsFor(limit, true);

        // The actual experiments are performed here, with limits going from 1
        // to 2^30:
        for (int exponent = 0, limit = 1; exponent != 31; exponent++, limit *= 2)
            performExperimentsFor(limit, false);
    }

}
