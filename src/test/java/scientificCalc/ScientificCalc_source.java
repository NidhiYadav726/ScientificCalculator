package scientificCalc;

public class ScientificCalc_source {
    public double addition(double a, double b) {
        return a + b;
    }
    public double subtraction(double a, double b) {
        return a - b;
    }
    public double multiplication(double a, double b) {
        return a * b;
    }
    public double division(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
    //invalidAddition
    public static double add(String operand1, String operand2) throws NumberFormatException{
        double op1 = Double.parseDouble(operand1);
        double op2 = Double.parseDouble(operand2);
        return op1 + op2;
    }
    //invalidDivision
    public static double divide(double n1, double n2) throws ArithmeticException {
        if (n2 == 0){
            throw new ArithmeticException("cannot be divided by zero");
        }
        return n1 / n2 ;
    }
    public int squareRoot(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }
        return (int) Math.sqrt(num);
    }
    public int power(int base,int exponent) {
        return (int) Math.pow(base, exponent);
    }
    public double sin(double angle) {
        return Math.sin(Math.toRadians(angle));
    }
    public double cos(double angle) {
        return Math.cos(Math.toRadians(angle));
    }
    public double tan(double angle) {
        return Math.tan(Math.toRadians(angle));
    }
}

