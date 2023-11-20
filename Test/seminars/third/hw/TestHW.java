package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestHW {

    MainHW mainHW;

    @BeforeEach
    void setUp() {
        mainHW = new MainHW();
    }


    /**
     * 1. Напишите тесты, покрывающие на 100% метод evenOddNumber, который проверяет, является ли
     * <p>
     * переданное число четным или нечетным
     */

    @Test
    void testEvenNumber() {
        assertTrue(mainHW.evenOddNumber(2));
    }

    @Test
    void testOddNumber() {
        assertFalse(mainHW.evenOddNumber(3));
    }

    /**
     * 2. Разработайте и протестируйте метод numberInInterval, который проверяет, попадает ли
     * <p>
     * переданное число в интервал (25;100)
     */

    @Test
    void testNumberInInterval() {
        assertTrue(mainHW.numberInInterval(35));
    }

    @Test
    void testNumberNotInInterval() {
        assertFalse(mainHW.numberInInterval(15));
    }
}