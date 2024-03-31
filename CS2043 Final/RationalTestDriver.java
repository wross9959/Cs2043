/*
* To compile: javac -cp junit3.8.1.jar RationalTestDriver.java Rational.java
* To run: java -cp .:junit3.8.1.jar RationalTestDriver.java
* to get Junit Terminal text:
junit.textui.TestRunner.run(RationalTestDriver.class);
* To get Junit GUI:
junit.swingui.TestRunner.run(RationalTestDriver.class);
*/


import junit.framework.TestCase;

public class RationalTestDriver extends TestCase {
    
    public void testConstructor() {
       
        Rational rational1 = new Rational(1,5);
        assertEquals(1, rational1.getX());
        assertEquals(5, rational1.getY());
        assertEquals(0.5, rational1.getDecimal(), 0.00001);
    }

    public void testGetX() {
        Rational rational1 = new Rational(15, 6);
        assertEquals(15, rational1.getX());
    }

    public void testGetY() {
        Rational rational1 = new Rational(27, 56);
        assertEquals(56, rational1.getY());
    }
    public void testGetDecimal() {
        Rational rational1 = new Rational(7, 2);
        assertEquals(3.0, rational1.getDecimal(), 0.00001);
    }

    public void testAdd() {
        Rational rational1 = new Rational(12, 34);
        Rational rational2 = new Rational(11, 34);
        rational1.add(rational2);
        assertEquals(782, rational1.getX());
        assertEquals(1156, rational1.getY());
    }

    public void testAddPositive() {
        Rational rational1 = new Rational(2, 6);
        Rational rational2 = new Rational(5, 7);
        rational1.add(rational2);
        assertEquals(44, rational1.getX()); 
        assertEquals(42, rational1.getY()); 
    }

    public void testAddNegative() {
        Rational rational1 = new Rational(-6, 2);
        Rational rational2 = new Rational(1, 3);
        rational1.add(rational2);
        assertEquals(-16, rational1.getX()); 
        assertEquals(6, rational1.getY());
    }

    public void testAddZero() {
        Rational rational1 = new Rational(6, 2);
        Rational rational2 = new Rational(0, 1);
        rational1.add(rational2);
        assertEquals(6, rational1.getX()); 
        assertEquals(2, rational1.getY());
    }

    public void testAddWithZeroNumerator() {
        Rational rational1 = new Rational(13, 4);
        Rational rational2 = new Rational(0, 7);
        rational1.add(rational2);
        assertEquals(91, rational1.getX()); 
        assertEquals(28, rational1.getY()); 
    }    
    
    // The main method to run the tests
    public static void main(String[] args) {
        //junit.textui.TestRunner.run(RationalTestDriver.class);
        // junit.swingui.TestRunner.run(RationalTestDriver.class);
        }
}
