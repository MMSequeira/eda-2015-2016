package pt.europeia.eda.piazza.sizer;

import static java.lang.System.out;
import static pt.europeia.eda.ObjectSizeFetcher.sizeOf;

public class ObjectSizeTester {

    private static void show(final String description, final long size) {
        out.println(description + ": " + size + " bytes");
    }

    // Run with the following VM arguments:
    // -javaagent:lib/sizer.jar – So that instrumentation is activated.
    // -XX:-UseCompressedOops – To turn off ordinary object pointer
    // optimization, so that results are closer to the ones or the book (which
    // was written before this optimization became the default).
    public static void main(final String[] arguments) {
        // An instance of an empty class uses 16 bytes:
        show("Simple (empty class)", sizeOf(new Simple()));

        // An instance of an inner class uses 16 + 8 = 24 bytes:
        show("Simple.Inner (empty inner class)",
                sizeOf(new Simple().new Inner()));

        // An int uses 4 bytes, so a class with a single int attribute uses 16 +
        // 4 = 20 bytes. But sizes must be multiples of 8, so the size is
        // rounded up to 24 bytes:
        show("OneInt (class with one int)", sizeOf(new OneInt()));

        // An int uses 4 bytes, so a class with two int attributes uses 16 + 2 ×
        // 4 = 24 bytes:
        show("TwoInts (class with two ints)", sizeOf(new TwoInts()));

        // An array uses 24 bytes plus its length times the size of each item,
        // rounded up to the closest multiple of 8 bytes. Hence, an empty array
        // uses just 24 bytes:
        show("int[0] (empty int array)", sizeOf(new int[0]));

        // An array with one int uses 24 + 1 × 4 = 28 bytes. Rounded up, it gets
        // to 32:
        show("int[1] (one-item int array)", sizeOf(new int[1]));

        // An array with two ints uses 24 + 2 × 4 = 32 bytes:
        show("int[2] (two-item int array)", sizeOf(new int[2]));

        // An instance of a class with a non-value type part which is an
        // instance of an empty class uses 16 + 8 + 16 bytes. However, we only
        // get 16 + 8 = 24 bytes, since sizeOf() estimates object sizes
        // shallowly:
        show("Whole (class with a referenced part)", sizeOf(new Whole()));
    }

}
