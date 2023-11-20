package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import seminars.third.tdd.MoodAnalyser;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {
    SomeService someService;
    MoodAnalyser moodAnalyser;

    @BeforeEach
    void Setup() {
        someService = new SomeService();
        moodAnalyser = new MoodAnalyser();
    }

    // 3.1.

    @Test
    void multipleThreeNotFiveReturnsFizz() {
        assertEquals("Fizz", SomeService.fizzBuzz(3));
    }

    @Test
    void multipleThreeNotFiveReturnsBuzz() {
        assertEquals("Buzz", SomeService.fizzBuzz(5));
    }

    @Test
    void multipleThreeNotFiveReturnsFizzBuzz() {
        assertEquals("FizzBuzz", SomeService.fizzBuzz(15));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 7, 11, 17, 22})
        //параметризованный тест
    void multipleThreeNotFiveReturnsNumber(int i) {
        assertEquals(String.valueOf(i), SomeService.fizzBuzz(i));
    }

    //3.2

    @Test
    void returnTrueMassiveFirstLast6() {
        assertTrue(someService.firstLast6(new int[]{6, 2, 3}));
        assertTrue(someService.firstLast6(new int[]{2, 3, 6}));
    }

    @Test
    void returnFalseMassiveFirstLastNone6() {
        assertFalse(someService.firstLast6(new int[]{3, 2, 3}));
        assertFalse(someService.firstLast6(new int[]{2, 3, 2}));
    }


    //3.3
//    @Test
//    void insufficientCoverageTest(){
////        System.out.println(someService.calculatingDiscount(2000.0, 10));
//        assertThat(someService.calculatingDiscount(2000.0, 50))
//                .isEqualTo(1000); // обычная скидка
//        assertThat(someService.calculatingDiscount(2000.0, 100))
//                .isEqualTo(0); // обычная скидка
//        assertThat(someService.calculatingDiscount(2000.0, 0))
//                .isEqualTo(2000); // обычная скидка
//    }

    @ParameterizedTest
    @CsvSource({"2000.0,50,1000",
                "2000.0,100,0",
                "2000.0,0,2000"
    })

    void insufficientCoverageTest(double i, int j, int k) {
        assertThat(someService.calculatingDiscount(i, j)).isEqualTo(k);
    }

    @Test
    void discountOverThat100() {

        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, 101))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки больше 100%
    }

    @Test
    void discountSubZero() {

        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки меньше 0
    }

    //3.4
    @Test
    void testLuckySum(){
        assertThat(someService.luckySum(1,4, 8)).isEqualTo(13);
    }

    @Test
    void testALuckySum(){
        assertThat(someService.luckySum(13,4, 8)).isEqualTo(12);

    }


    @Test
    void testBLuckySum() {
        assertThat(someService.luckySum(1, 13, 8)).isEqualTo(9);
    }


    @Test
    void testCLuckySum() {
        assertThat(someService.luckySum(1, 4, 13)).isEqualTo(5);
    }


    //3.5
    @Test
    void testMoodAnalyserGood(){
        assertThat(moodAnalyser.analyseMood("this day was happy")).isEqualTo("GoodVeryGood");
    }

    @Test
    void testMoodAnalyserBad(){
        assertThat(moodAnalyser.analyseMood("this day was bad")).isEqualTo("SadVerysad");
    }

    @Test
    void testMoodAnalyserSoSo(){
        assertThat(moodAnalyser.analyseMood("this day was so so")).isEqualTo("So so");
    }


}