package fr.uavignon.ceri.tp2.data;


    import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.List;

public class BookRepository {
        private BookDao bookDao;
        private LiveData<List<Book>> allBooks;
        private MutableLiveData<Book> selectedBook;

        public BookRepository(Application application) {
            BookRoomDatabase db = BookRoomDatabase.getDatabase(application);
            bookDao = db.bookDao();
            allBooks = (LiveData<List<Book>>) bookDao.getAllBooks();
            selectedBook = new MutableLiveData<>();
        }

        public LiveData<List<Book>> getAllBooks() {
            return allBooks;
        }

        public void insertBook(Book book) {
            BookRoomDatabase.databaseWriteExecutor.execute(() -> {
                bookDao.insertBook(book);
            });
        }

        public void updateBook(Book book) {
            BookRoomDatabase.databaseWriteExecutor.execute(() -> {
                bookDao.updateBook(book);
            });
        }

        public void deleteBook(Book book) {
            BookRoomDatabase.databaseWriteExecutor.execute(() -> {
                bookDao.deleteBook(book);
            });
        }

        public LiveData<Book> getBook(long id) {
            BookRoomDatabase.databaseWriteExecutor.execute(() -> {
                selectedBook.postValue(bookDao.getBook(id));
            });
            return selectedBook;
        }

        public void setSelectedBook(Book book) {
            selectedBook.setValue(book);
        }
    }

