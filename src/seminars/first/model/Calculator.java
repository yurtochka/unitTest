package seminars.first.model;

public class Calculator {
    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Ну нельзя делить на ноль");
                }
            default:
                throw new IllegalStateException("Значение: " + operator);
        }
        return result;
    }

    // HW1:
    //  В классе Calculator создайте метод calculateDiscount, который принимает сумму покупки и процент скидки и возвращает сумму с учетом скидки.
    //  Проверить этот метод с использованием библиотеки AssertJ.
    //  Если метод calculateDiscount получает недопустимые аргументы, он должен выбрасывать исключение ArithmeticException.
    // purchaseAmount - сумма покупки
    // discountAmount - размер скидки
    public static double squareRootExtraction(double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Значение не может быть отрицательным");
        }
        return Math.sqrt(num);
    }


    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {


        if (purchaseAmount < 0 || discountAmount < 0 || discountAmount > 100) {
            throw new IllegalArgumentException("Неверная сумма скидки");
        }
        double resultAmount = purchaseAmount - (purchaseAmount * discountAmount) / 100;
        return resultAmount; // Метод должен возвращать сумму покупки со скидкой
    }

    public static void getOperand() {
    }
}