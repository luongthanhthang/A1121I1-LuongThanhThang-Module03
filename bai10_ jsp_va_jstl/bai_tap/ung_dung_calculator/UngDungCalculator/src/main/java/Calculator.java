public class Calculator {
    public static float calculate(float number1, float number2, String operator) {
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                if (number2 == 0) {
                    throw new ArithmeticException("ERROR division zero !!!");
                } else {
                    return number1 / number2;
                }
        }
        return (float) 0.0;
    }
}
