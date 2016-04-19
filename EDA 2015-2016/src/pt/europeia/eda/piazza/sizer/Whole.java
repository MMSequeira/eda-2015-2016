package pt.europeia.eda.piazza.sizer;

import static pt.europeia.eda.ObjectSizeFetcher.sizeOf;

public class Whole {

    private Part part = new Part();

    private static class Part {

    }

    // Using ObjectSizeFetcher.sizeOf() with an instance of Whole results in 16
    // + 8 bytes, since the memory used by the part is not taken into account.
    // That is, ObjectSizeFetcher.sizeOf() estimates memory shallowly. The
    // problem may be solved using instrumentation code, such as the method
    // below. This is not an elegant solution, but it works. Ideally, parts
    // would be marked with a special annotation @Part and the
    // ObjectSizeFetcher.sizeOf() would follow references or collections of
    // references thus annotated to estimate the true size of an object, i.e.,
    // including the size of its parts.
    //
    // Please take into account that parts may contain other parts. Also, take
    // care when using objects with long sequences of parts. If recursion is
    // used to find the memory use in such cases, a stack overflow error may
    // easily occurs. Prefer iteration over recursion, in these cases.
    public long memorySize() {
        return sizeOf(this) + sizeOf(part);
        // If the part contains other parts, e.g., forming a linked list,
        // you must go over all these indirect parts to calculate total memory
        // use of the object. If the sequences of parts are long, prefer
        // iteration to recursion.
    }
}
