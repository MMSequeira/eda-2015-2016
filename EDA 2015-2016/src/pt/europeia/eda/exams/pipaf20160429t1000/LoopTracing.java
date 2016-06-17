package pt.europeia.eda.exams.pipaf20160429t1000;

import static java.lang.System.out;

public class LoopTracing {

    private static int incrementsOfLoop1(final int N) {
        int sum = 0;

        for (int i = N; i != 0; i -= 2)
            sum++;
        for (int j = 0; j != N; j += 2)
            sum++;

        return sum;
    }

    private static int incrementsOfLoop2(final int N) {
        int sum = 0;

        for (int i = N; i != 1; i /= 2)
            for (int j = 0; j != N; j += i)
                sum++;

        return sum;
    }

    public static void main(final String[] arguments) {
        int N;

        out.println("Loop 1:");
        N = 10;
        out.println("\tN = " + N + ": " + incrementsOfLoop1(N)
                + " increments, should be " + N + ".");
        N = 20;
        out.println("\tN = " + N + ": " + incrementsOfLoop1(N)
                + " increments, should be " + N + ".");

        out.println("Loop 2:");
        N = 16;
        out.println("\tN = " + N + ": " + incrementsOfLoop2(N)
                + " increments, should be " + (N - 1) + ".");
        N = 32;
        out.println("\tN = " + N + ": " + incrementsOfLoop2(N)
                + " increments, should be " + (N - 1) + ".");
    }

}
