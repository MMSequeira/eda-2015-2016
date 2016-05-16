package pt.europeia.eda.book.chapter2.section3;

import static java.lang.System.out;

import java.util.Arrays;

public class QuicksortStabilityTester {

    public static void main(final String[] arguments) {
        out.println("Keys in book:");
        
        final Key[] keysInBook = {
            new Key('B', 1),
            new Key('C', 1),
            new Key('C', 2),
            new Key('A', 1)
        };
        
        out.println("\tBefore: " + Arrays.toString(keysInBook));

        QuickNoShuffle.sort(keysInBook);
        
        out.println("\tAfter: " + Arrays.toString(keysInBook));

        out.println("Correct keys in book:");

        final Key[] correctKeys = {
            new Key('B', 1),
            new Key('C', 1),
            new Key('A', 1),
            new Key('C', 2)
        };
        
        out.println("\tBefore: " + Arrays.toString(correctKeys));

        QuickNoShuffle.sort(correctKeys);
        
        out.println("\tAfter: " + Arrays.toString(correctKeys));
    }
    
    private static class Key implements Comparable<Key> {
        private final char letter;
        private final int originalOrder;
        
        public Key(final char letter, final int originalOrder) {
            this.letter = letter;
            this.originalOrder = originalOrder;
        }
        
        @Override
        public int compareTo(final Key other) {
            return letter - other.letter;
        }
        
        @Override
        public String toString() {
            return "('" + letter + "', " + originalOrder + ")";
        }
    }
    
}
