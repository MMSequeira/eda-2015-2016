package pt.europeia.eda.exams.pipaf20160628t1000;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// A special kind of scanner which allows ints to be read from a file. It also
// allows the next int in the file to be peeked (i.e., its value to be known)
// before actually reading it:
public class PeekableIntScanner {
    private final Scanner scanner;
    private Integer nextInteger;

    // Constructs a new peakable int scanner:
    public PeekableIntScanner(final File file) throws FileNotFoundException {
        scanner = new Scanner(file);
        nextInteger = scanner.hasNextInt() ? scanner.nextInt() : null;
    }

    // Returns true if there is an int ready to be read:
    public boolean hasNext() {
        return nextInteger != null;
    }

    // Reads and returns the next int if there is an int ready to be read:
    public int next() {
        if (!hasNext())
            throw new IllegalStateException("No next integer.");

        final Integer currentInteger = nextInteger;
        nextInteger = scanner.hasNext() ? scanner.nextInt() : null;
        return currentInteger;
    }

    // Returns the next int if there is an int ready to be read, but does not
    // actually read it:
    public int peek() {
        if (!hasNext())
            throw new IllegalStateException("No next integer.");

        return nextInteger;
    }
}
