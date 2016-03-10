package pt.europeia.eda.iga.session4;

import static java.lang.System.out;

public class ToStringTester {

    // Prints instances of classes A, which overrides Object.toString(), and B,
    // which does not override Object.toString():
    public static void main(final String[] arguments) {
        final A a = new A();
        final B b = new B();

        // When passed a (reference) to an object for which a more specialized
        // version of PrintStream.println() does not exist, the version
        // of PrintStream.println() receiving an Object reference as argument is
        // called, which in turn (indirectly) calls the object toString()
        // method, printing the resulting string in the output:
        out.println(a);
        out.println(b);
    }

}
