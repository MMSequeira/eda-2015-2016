package pt.europeia.eda.extra.session3;

import static java.lang.System.out;

// A few experiments of equality and identity using immutable value class
// Rational: 
public class RationalTests {

    public static void main(final String[] arguments) {
        // After these statements:
        //   a) a, b, and c are *references* to Rational instances.
        //   b) a and b refer to distinct, though equal, Rational instances.
        //   c) c and a refer to the same Rational instance.
        Rational a = new Rational(1, 2);
        Rational b = new Rational(1, 2);
        Rational c = a;
        
        // Since a and b contain different references, i.e., they refer to
        // distinct Rational instances, a == b yields false: 
        out.println(a == b);
        
        // Since a and c contain equal references, i.e., they refer to the same
        // Rational instance, a == c yields true: 
        out.println(a == c);
        
        // a and b contain different references, i.e., they refer to
        // distinct Rational instances. However, these distinct instances have
        // the same value, hence a.equals(b) yields true: 
        out.println(a.equals(b));
        
        // Since a and c contain equal references, i.e., they refer to the same
        // Rational instance, a.equals(c) must yields true, since an object is
        // always equal to itself: 
        out.println(a.equals(c));
    }
    
}
