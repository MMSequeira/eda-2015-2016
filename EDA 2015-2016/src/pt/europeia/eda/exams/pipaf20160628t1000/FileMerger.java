package pt.europeia.eda.exams.pipaf20160628t1000;

import static java.lang.System.err;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class FileMerger {

    private static void merge(final File inputFile1, final File inputFile2,
            final File outputFile) throws FileNotFoundException {
        final PeekableIntScanner intScanner1 = new PeekableIntScanner(inputFile1);
        final PeekableIntScanner intScanner2 = new PeekableIntScanner(inputFile2);

        final PrintWriter output = new PrintWriter(outputFile);

        while (intScanner1.hasNext() || intScanner2.hasNext())
            if (!intScanner2.hasNext())
                output.println(intScanner1.next());
            else if (!intScanner1.hasNext())
                output.println(intScanner2.next());
            else if (intScanner1.peek() < intScanner2.peek())
                output.println(intScanner1.next());
            else if (intScanner1.peek() > intScanner2.peek())
                output.println(intScanner2.next());
            else {
                intScanner1.next();
                intScanner2.next();
            }

        output.close();
    }

    public static void main(final String[] arguments) {
        try {
            final File temporaryFile = File.createTempFile("mergeaux", null);
            temporaryFile.deleteOnExit();

            merge(new File(arguments[0]), new File(arguments[1]),
                    temporaryFile);
            merge(temporaryFile, new File(arguments[2]),
                    new File(arguments[3]));
        } catch (final IOException exception) {
            err.println("Error merging: " + exception);
        }
    }

}
