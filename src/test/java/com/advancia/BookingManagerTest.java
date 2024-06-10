package com.advancia;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookingManagerTest {
	
	private static HotelDao hotelDaoMock;
	private static BookingManager bookingManager;
	
	@BeforeAll
    public static void setup() throws SQLException {
        // eseguito una volta
        // prima di tutti i metodi di test
		hotelDaoMock = mock(HotelDao.class);
		bookingManager = new BookingManager(hotelDaoMock);
		List<String> availableRooms = Arrays.asList("A");
		when(hotelDaoMock.fetchAvailableRooms()).thenReturn(availableRooms);
    }
    
    @BeforeEach
    public void init() {
        // eseguito prima di ogni metodo di test
    }
    
    @AfterEach
    public void clear() {
        // eseguito dopo ogni metodo di test
    }
    
    @AfterAll
    public static void cleanup() {
        // eseguito una volta
        // dopo di tutti i metodi di test
    }

	@Test
	void checkAvailableRoomsTrue() throws SQLException {
		
		assertTrue(bookingManager.checkRoomAvailability("A"));
	}

	@Test
	void checkAvailableRoomsFalse() throws SQLException {
		assertFalse(bookingManager.checkRoomAvailability("B"));
	}
}
