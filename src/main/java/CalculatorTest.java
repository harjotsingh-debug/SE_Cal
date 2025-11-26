import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator calc = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(10, calc.add(5, 5));
    }

    @Test
    public void testSubtract() {
        assertEquals(0, calc.subtract(5, 5));
    }

    @Test
    public void testMultiply() {
        assertEquals(25, calc.multiply(5, 5));
    }

    @Test
    public void testDivide() {
        assertEquals(2.0, calc.divide(10, 5), 0.001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        calc.divide(10, 0);
    }
}
