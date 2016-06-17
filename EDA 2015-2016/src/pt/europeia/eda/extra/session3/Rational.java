package pt.europeia.eda.extra.session3;

// Incomplete immutable value class representing rational numbers. The class
// should:
//   a) Guarantee normalized representation (mutually prime numerator and
//      denominator with non-negative denominator).
//   b) Be made Comparable.
//   c) Redefine hashCode() so that it returns the same value for equal Rational
//      instances.

// It is a good practice to make value classes final: 
public final class Rational {
    // It helps if attributes of immutable classes are final:
    private final int numerator;
    private final int denominator;
    
    public Rational(int numerator, int denominator) {
        // The values stored should be normalized. For instance, if the
        // parameters were 4 and -6 (4/-6), then the value stored in
        // this.numerator should be -2 and the value stored in this.denominator
        // should be 3 (4/-6 = -2/3):
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    public int numerator() {
        return numerator;
    }

    public int nenominator() {
        return denominator;
    }

    // This is a value class, so it must override the default implementation of
    // the method, inherited from Object, which does *not* compare the objects
    // for equality, rather comparing them for *identity*:
    @Override
    public boolean equals(final Object other) {
        if (this == other)
            return true;
        
        if (other == null)
            return false;
        
        if (other.getClass() != getClass())
            return false;
        
        final Rational that = (Rational) other;
        
        return numerator == that.numerator && denominator == that.denominator;
    }
}
