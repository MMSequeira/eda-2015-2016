package pt.europeia.eda.exams.pipaf20160628t1000;

import static java.lang.System.out;

public class LoopTracing {

    private static int incrementsOfLoop1(final int N) {
        int sum = 0;
        for (int i = N; i != 1; i /= 2)
            sum++;
        for (int i = 0; i != N; i += 2)
            sum++;

        return sum;
    }

    private static int incrementsOfLoop2(final int N) {
        int sum = 0;
        for (int i = N; i != 0; i -= 2)
            for (int j = 0; j != N; j += 2)
                sum++;

        return sum;
    }

    private static int lg(int n) {
        if (n <= 0)
            throw new IllegalArgumentException(
                    "Attempt to calculate logarithm of non-positive number.");
        int lg = 0;
        while (n != 1) {
            lg++;
            n /= 2;
        }

        return lg;
    }

    public static void main(final String[] arguments) {
        int N;

        out.println("Loop 1:");
        N = 32;
        out.println("\tN = " + N + ": " + incrementsOfLoop1(N)
                + " increments, should be " + (N / 2 + lg(N)) + ".");
        N = 4;
        out.println("\tN = " + N + ": " + incrementsOfLoop1(N)
                + " increments, should be " + (N / 2 + lg(N)) + ".");

        out.println("Loop 2:");
        N = 32;
        out.println("\tN = " + N + ": " + incrementsOfLoop2(N)
                + " increments, should be " + N * N / 4 + ".");
        N = 4;
        out.println("\tN = " + N + ": " + incrementsOfLoop2(N)
                + " increments, should be " + N * N / 4 + ".");
    }

}
