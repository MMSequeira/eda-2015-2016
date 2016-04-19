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
        final Simple simple = new Simple();
        show("Simple (empty class)", sizeOf(simple));

        // An instance of an inner class uses 16 + 8 = 24 bytes:
        final Simple.Inner inner = simple.new Inner();
        show("Simple.Inner (empty inner class)", sizeOf(inner));

        // An int uses 4 bytes, so a class with a single int attribute uses 16 +
        // 4 = 20 bytes. But sizes must be multiples of 8, so the size is
        // rounded up to 24 bytes:
        final OneInt oneInt = new OneInt();
        show("OneInt (class with one int)", sizeOf(oneInt));

        // An int uses 4 bytes, so a class with two int attributes uses 16 + 2 ×
        // 4 = 24 bytes:
        final TwoInts twoInts = new TwoInts();
        show("TwoInts (class with two ints)", sizeOf(twoInts));

        // An array uses 24 bytes plus its length times the size of each item,
        // rounded up to the closest multiple of 8 bytes. Hence, an empty array
        // uses just 24 bytes:
        final int[] emptyIntArray = new int[0];
        show("int[0] (empty int array)", sizeOf(emptyIntArray));

        // An array with one int uses 24 + 1 × 4 = 28 bytes. Rounded up, it gets
        // to 32:
        final int[] oneIntArray = new int[1];
        show("int[1] (one-item int array)", sizeOf(oneIntArray));

        // An array with two ints uses 24 + 2 × 4 = 32 bytes:
        final int[] twoIntsArray = new int[2];
        show("int[2] (two-item int array)", sizeOf(twoIntsArray));

        // An instance of a class with a non-value type part which is an
        // instance of an empty class uses 16 + 8 + 16 = 40 bytes. However, we
        // only get 16 + 8 = 24 bytes, since sizeOf() estimates object sizes
        // shallowly:
        final Whole whole = new Whole();
        show("Whole (class with a referenced part)", sizeOf(whole));

        // It is possible to use libraries that estimate object sizes deeply,
        // following every reference. However, this is not what we usually want,
        // since an object may reference another that is not a part of itself.
        // This problem may be solved by distinguishing two types of references:
        // references corresponding to whole-part relations (composition, in
        // UML) and references corresponding to mere associations. This may be
        // done using annotations. The size estimation library, however, must be
        // prepared to deal with these annotations.
        //
        // A poor alternative is to use instrumentation code in the class
        // itself. This gets us the correct estimate of the object memory use,
        // including its parts:
        show("Whole (class with a referenced part and instrumentation)",
                whole.memorySize());
    }

}
