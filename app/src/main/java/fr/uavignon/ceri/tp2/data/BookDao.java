package fr.uavignon.ceri.tp2.data;

import java.util.List;

public interface BookDao {

    void insertBook(Book book);
    void updateBook(Book book);
    void deleteBook(Book id);
    Book getBook(long id);
    List<Book> getAllBooks();

    void deleteAllBooks();
}
