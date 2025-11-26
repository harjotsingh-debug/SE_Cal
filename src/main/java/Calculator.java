public class Calculator {

    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
    public double divide(int a, int b) {
        if (b == 0) throw new IllegalArgumentException("Cannot divide by zero");
        return (double) a / b;
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java -jar calculator-app.jar <num1> <op> <num2>");
            return;
        }

        int num1 = Integer.parseInt(args[0]);
        String op = args[1];
        int num2 = Integer.parseInt(args[2]);
        Calculator calc = new Calculator();

        switch (op) {
            case "+": System.out.println(calc.add(num1, num2)); break;
            case "-": System.out.println(calc.subtract(num1, num2)); break;
            case "*": System.out.println(calc.multiply(num1, num2)); break;
            case "/": System.out.println(calc.divide(num1, num2)); break;
            default: System.out.println("Invalid operator");
        }
    }
}
