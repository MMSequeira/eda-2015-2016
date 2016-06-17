package pt.europeia.eda.extra.session3;

import static java.lang.System.out;

// A few experiments with Integers, showing that Java support for this wrapper,
// immutable, value class is more subtle than the syntax seems to show.
public class IntegerExperiments {

    private static void experimentWithInteger() {
        out.println("Integer experiments:");
        
        // a, b, and c are references, not integers. They refer to Integer
        // instances which are created automatically by auto-boxing:
        out.println("\tCreate reference a refering to Integer of value 10.");
        Integer a = 10;
        out.println("\tCreate reference b refering to Integer of value 20.");
        Integer b = 20;

        // After this statement, c contains the same reference as b:
        out.println("\tCreate reference c refering to the same Integer as b.");
        Integer c = b;

        // Since c and b contain equal references, i.e., both refer to the same
        // Integer instance, comparing them using == yields true:
        out.println("\tc == b: " + (c == b) + " (should be true)");

        // Since c and b contain the equal references, i.e., both refer to the
        // same Integer instance, comparing them using the equals() method also
        // yields true, which is the same as saying an object always equals
        // itself:
        out.println("\tc.equals(b): " + c.equals(b) + " (should be true)");

        // After this statement, d contains a reference to a new Integer of
        // value 20:
        out.println("\tCreate reference d refering to a new Integer of value 20.");
        Integer d = new Integer(20);

        // Since d and b contain references to distinct Integer instances,
        // comparing them using == yields false:
        out.println("\td == b: " + (d == b) + " (should be false)");

        // Since d and b contain references to distinct Integer instances with
        // equal value 20, comparing them using the equals() method yields true:
        out.println("\td.equals(b): " + d.equals(b) + " (should be true)");

        // This statement changes the reference in b to another Integer instance
        // with value 30:
        out.println("\tChange reference b to refer to an Integer of value 30.");
        b += a;

        out.println("\tb: " + b + " (should be 30)");

        // Reference c is unchanged, i.e., it still refers to the *unchanged*
        // Integer instance with value 20 that was initially, but is no longer,
        // referenced by b:
        out.println("\tc: " + c + " (should be 20)");

        // Since c and b now contain different references, i.e., they refer to
        // distinct Integer instances, comparing them using == yields false:
        out.println("\tc == b: " + (c == b) + " (should be false)");
    }

    private static void experimentWithInt() {
        out.println("int experiments:");
        
        // a, b, and c are ints, a primitive type, and hence a value type. They
        // are *not* references:
        out.println("\tCreate int a with value 10.");
        int a = 10;
        out.println("\tCreate int b with value 20.");
        int b = 20;

        // After this statement, c contains the same int value as b:
        out.println("\tCreate int c with value 20, equal to the one in b.");
        int c = b;

        // Since c and b contain equal int values, comparing them using ==
        // yields true:
        out.println("\tc == b: " + (c == b) + " (should be true)");

        // c is an int, not and Integer, hence it is a variable of a value
        // type, not a reference type. Value types, in Java, don't have methods.
        // Thus, it is not possible to call method equals():
        out.println("\tc.equals(b): " /* + c.equals(b) */ + " (impossible)");

        // After this statement, d contains int value 20, not a reference:
        out.println("\tCreate int d with value 20, equal to the one in b.");
        int d = 20;

        // Since d and b contain the same int value, comparing them using ==
        // yields true:
        out.println("\td == b: " + (d == b) + " (should be true)");

        // Since d is an int, it is not possible to call method equals():
        out.println("\td.equals(b): " /* + d.equals(b) */ + " (impossible)");

        // This statement changes the value in b to 30:
        out.println("\tChange the value in b  to 30.");
        b += a;

        out.println("\tb: " + b + " (should be 30)");

        // The value in c is unchanged, i.e., it is still 20:
        out.println("\tc: " + c + " (should be 20)");

        // Since c and b now contain different values, comparing them using ==
        // yields false:
        out.println("\tc == b: " + (c == b) + " (should be false)");
    }

    public static void main(final String[] arguments) {
        experimentWithInteger();
        experimentWithInt();
    }

}
