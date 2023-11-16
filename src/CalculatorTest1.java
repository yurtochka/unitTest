import seminars.first.model.Calculator;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest1 {
    public static void main(String[] args) {

        testCalculateDiscount();

        // Проверка базового функционала с целыми числами:
        if (8 != Calculator.calculation(2, 6, '+')) {
            throw new AssertionError("Ошибка");
        }

        if (0 != Calculator.calculation(2, 2, '-')) {
            throw new AssertionError("Ошибка");
        }

        if (14 != Calculator.calculation(2, 7, '*')) {
            throw new AssertionError("Ошибка");
        }

        if (2 != Calculator.calculation(100, 50, '/')) {
            throw new AssertionError("Ошибка");
        }


        // Проверка базового функционала с целыми числами, с использованием утверждений:
        assert 8 == Calculator.calculation(2, 6, '+');
        assert 0 == Calculator.calculation(2, 2, '-');
        assert 14 == Calculator.calculation(2, 7, '*');
        assert 2 == Calculator.calculation(100, 50, '/');


        System.out.println(Calculator.calculation(2_147_483_647, 1, '+')); // integer overflow
        System.out.println(Calculator.squareRootExtraction(169));

    }

//  HW1
//  Тесты для проверки поведения алгоритма.
    public static void testCalculateDiscount() {
        // Проверка, что метод выбрасывает исключение при недопустимых аргументах
        assertThatThrownBy(() -> Calculator.calculatingDiscount(-1, 50))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Неверная сумма скидки");

        assertThatThrownBy(() -> Calculator.calculatingDiscount(100, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Неверная сумма скидки");

        assertThatThrownBy(() -> Calculator.calculatingDiscount(100, 101))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Неверная сумма скидки");

        // Проверка на возврат правильной суммы покупки со скидкой
        assertThat(Calculator.calculatingDiscount(10, 10)).isEqualTo(90.0);
        assertThat(Calculator.calculatingDiscount(200, 20)).isEqualTo(160.0);
        assertThat(Calculator.calculatingDiscount(500, 50)).isEqualTo(250.0);

    }
}