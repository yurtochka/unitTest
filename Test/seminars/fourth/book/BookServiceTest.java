package seminars.fourth.book;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BookServiceTest {
    BookService bookService;
    BookRepository bookRepository;

    @BeforeEach
    void setUp(){
        bookRepository = mock(BookRepository.class);
        bookService = new BookService(bookRepository);
    }

    @Test
    void testFindByIdBook(){
// Arrange
        when(bookRepository.findById("11")).thenReturn(new Book("11", "The Master and Margarita", "Mikhail Bulgakov"));
// Act
        Book resFind = bookService.findBookById("11");
// Assert
        assertEquals("The Master and Margarita", resFind.getTitle());
        assertEquals("Mikhail Bulgakov", resFind.getAuthor());
    }

    @Test
    void testFindAllBooks(){
// Arrange
        List<Book> books = Arrays.asList(new Book("22", "The Girl with the Dragon Tattoo", "Karl Stig-Erland Larsson"),
                new Book("23", "The Girl Who Played with Fire", "Karl Stig-Erland Larsson"));
        when(bookRepository.findAll()).thenReturn(books);
// Act
        List<Book> resAllBooks = bookService.findAllBooks();
// Assert
        verify(bookRepository).findAll();
        assertEquals(books, resAllBooks);
    }

}