package pt.europeia.eda.extra.session2;

import static java.lang.System.out;

/*
 * These are solutions to some of the CodingBat Java Array-1 exercises. 
 */
public class Array1 {

    /*
     * Given an array of ints length 3, return the sum of all the elements.
     * 
     * sum3({1, 2, 3}) → 6
     * 
     * sum3({5, 11, 2}) → 18
     * 
     * sum3({7, 0, 0}) → 7
     */
    public static int sum3(int[] nums) {
        int sum = 0;

        for (int num : nums)
            sum += num;

        return sum;

        // Since we are assured the array contains exactly three items, we may
        // solve the problem in a simpler way:
        // return nums[0] + nums[1] + nums[2];
    }

    /*
     * An utility method for printing results together with expected results.
     */
    private static void showResult(final Object result,
            final Object expectedResult) {
        out.println("\t" + result + " should be " + expectedResult);
    }

    public static void main(final String[] arguments) {
        out.println("sum3():");
        showResult(sum3(new int[] { 1, 2, 3 }), 6);
        showResult(sum3(new int[] { 5, 11, 2 }), 18);
        showResult(sum3(new int[] { 7, 0, 0 }), 7);
    }

}
