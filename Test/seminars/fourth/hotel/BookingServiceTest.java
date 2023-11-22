package seminars.fourth.hotel;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class BookingServiceTest {

    @Test
    void testHotel() {

        HotelService hotelService = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelService);

        when(hotelService.isRoomAvailable(anyInt())).thenReturn(false, true);

        assertEquals(false, bookingService.bookRoom(0));
        assertEquals(true, bookingService.bookRoom(0));

    }

    @Test
    void test() {
        HotelService hotelService = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelService);

        when(hotelService.isRoomAvailable(anyInt()))
                .thenAnswer(inv -> {
                    int roomNumber = inv.getArgument(0);
                    return roomNumber % 2 == 0;

                });
        assertTrue(bookingService.bookRoom(2));
        assertFalse(bookingService.bookRoom(1));
    }
}