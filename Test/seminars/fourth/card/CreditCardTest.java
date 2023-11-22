package seminars.fourth.card;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditCardTest {
    CreditCard creditCard;
    @BeforeEach
    void setUp(){
        creditCard = new CreditCard("123456789", "Tosya Kruglova", "12.11.2023", "123");
    }

    @Test
    void testGetCardNumber(){
        assertEquals("123456789", creditCard.getCardNumber());
    }

    @Test
    void testGetCardHolder(){
        assertEquals("Tosya Kruglova", creditCard.getCardHolder());
    }
    @Test
    void testGetCardExpiryDate(){
        assertEquals("12.11.2023", creditCard.getExpiryDate());
    }

    @Test
    void testGetCardCVV(){
        assertEquals("123", creditCard.getCvv());
    }

    @Test
    void TestCharge(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();


        System.setOut(new PrintStream(outputStream));
        creditCard.charge(1100.00);

        assertEquals("Charged amount 1100.0 from the card: 123456789", outputStream.toString().trim());

        System.setOut(null);
    }
}
