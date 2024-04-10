package ScientificCalculatorTest;

import org.testng.Assert;
import org.testng.annotations.*;
import scientificCalc.ScientificCalc_source;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class calculatorTest {
    ScientificCalc_source calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new ScientificCalc_source();
    }

    //Data provider for basicOperations
    @DataProvider(name = "testdata1")
    public Object[][] csvTestDataDataProvider1() throws IOException {
        List<Object[]> testData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("testdata1.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] value = line.split(",");
            double a = Double.parseDouble(value[0]);
            double b = Double.parseDouble(value[1]);
            testData.add(new Object[]{a, b});
        }
        reader.close();
        return testData.toArray(new Object[0][0]);
    }

    //Data Provider for testSquareRoot
    @DataProvider(name = "testdata2")
    public Object[][] csvTestDataDataProvider2() throws IOException {
        List<Object[]> testData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("testdata2.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] value = line.split(",");
            int num = Integer.parseInt(value[0]);
            testData.add(new Object[]{num});
        }
        reader.close();
        return testData.toArray(new Object[0][0]);
    }

    //Data Provider for testPower
    @DataProvider(name = "testdata_power")
    public Object[][] csvTestDataDataProvider3() throws IOException {
        List<Object[]> testData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("testdata_power.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] value = line.split(",");
            int base = Integer.parseInt(value[0]);
            int exponent = Integer.parseInt(value[1]);
            testData.add(new Object[]{base, exponent});
        }
        reader.close();
        return testData.toArray(new Object[0][0]);
    }

    //Data Provider for advancedOperations
    @DataProvider(name = "testdata3")
    public Object[][] csvTestDataDataProvider4() throws IOException {
        List<Object[]> testData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("testdata3.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] value = line.split(",");
            double angle = Double.parseDouble(value[0]);
            testData.add(new Object[]{angle});
        }
        reader.close();
        return testData.toArray(new Object[0][0]);
    }

    //testAddition
    @Test(groups = "basicOperations", priority = 1, dataProvider = "testdata1")
    public void testAddition(double a, double b) {
        ScientificCalc_source calculator = new ScientificCalc_source();
        double sum = calculator.addition(a, b);
        Assert.assertEquals(sum, a + b, "Invalid Sum");
    }

    //testSubtraction
    @Test(groups = "basicOperations", priority = 2, dataProvider = "testdata1")
    public void testSubtraction(double a, double b) {
        ScientificCalc_source calculator = new ScientificCalc_source();
        double difference = calculator.subtraction(a, b);
        Assert.assertEquals(difference, a - b, "Invalid Difference");
    }

    //testMultiplication
    @Test(groups = "basicOperations", priority = 3, dataProvider = "testdata1")
    public void testMultiplication(double a, double b) {
        ScientificCalc_source calculator = new ScientificCalc_source();
        double product = calculator.multiplication(a, b);
        Assert.assertEquals(product, a * b, "Invalid Product");
    }

    //testDivision
    @Test(groups = "basicOperations", priority = 4, dataProvider = "testdata1")
    public void testDivision(double a, double b) {
        ScientificCalc_source calculator = new ScientificCalc_source();
        double div = calculator.division(a, b);
        Assert.assertEquals(div, a / b, "Invalid Division");
    }

    //testSquareRoot
    @Test(groups = "advancedOperations", priority = 5, dataProvider = "testdata2")
    public void testSquareroot(int num) {
        ScientificCalc_source calculator = new ScientificCalc_source();
        int squareroot = calculator.squareRoot(num);
        Assert.assertEquals(squareroot, Math.sqrt(num), "Invalid Squareroot");
    }

    //testPower
    @Test(groups = "advancedOperations", priority = 6, dataProvider = "testdata_power")
    public void testPower(int base, int exponent) {
        ScientificCalc_source calculator = new ScientificCalc_source();
        int power = calculator.power(base, exponent);
        Assert.assertEquals(power, Math.pow(base, exponent), "Invalid result");
    }

    //invalidAddition
    @Test(priority = 7)
    public void testInvalidAddition() {
        try {
            calculator.add("akj", "deg");
            Assert.fail("Invalid addition test failed. Expected NumberFormatException, but no exception was thrown.");
        } catch (NumberFormatException e) {
            Assert.assertTrue(e.getMessage().startsWith("For input string:"), "Invalid exception message for invalid addition.");
        }
    }

    //invalidDivision
    @Test(priority = 8)
    public void testInvalidDivision() {
        try {
            calculator.divide(2, 0);
            Assert.fail("Invalid division test failed. Expected ArithmeticException, but no exception was thrown.");
        } catch (ArithmeticException e) {
            Assert.assertTrue(e.getMessage().contains("divided by zero"), "Invalid exception message for invalid division");
        }
    }

    //testSinFunction
    @Test(groups = "advancedOperations", priority = 9, dataProvider = "testdata3")
    public void testSinFunction(double angle) {
        ScientificCalc_source calculator = new ScientificCalc_source();
        double result = calculator.sin(angle);
        Assert.assertEquals(result, Math.sin(Math.toRadians(angle)), "Sin function failed");
    }

    //testCosFunction
    @Test(groups = "advancedOperations", priority = 10, dataProvider = "testdata3")
    public void testCosFunction(double angle) {
        ScientificCalc_source calculator = new ScientificCalc_source();
        double result = calculator.cos(angle);
        Assert.assertEquals(result, Math.cos(Math.toRadians(angle)), "Cos function failed");
    }

    //testTanFunction
    @Test(groups = "advancedOperations", priority = 11, dataProvider = "testdata3")
    public void testTanFunction(double angle) {
        ScientificCalc_source calculator = new ScientificCalc_source();
        double result = calculator.tan(angle);
        Assert.assertEquals(result, Math.tan(Math.toRadians(angle)), "Tan function failed");
    }

    @AfterMethod
    public void endOfCalculation() {
        System.out.println("Done with Computation ");
    }
}