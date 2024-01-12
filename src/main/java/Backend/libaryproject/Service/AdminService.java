package Backend.libaryproject.Service;

import Backend.libaryproject.Entity.Book;
import Backend.libaryproject.Interface.BookInterface;
import Backend.libaryproject.Interface.ReviewRepository;
import Backend.libaryproject.RequestModels.AddBookRequest;
import Backend.libaryproject.Respository.CheckOutRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@AllArgsConstructor
@Transactional
public class AdminService {

    private CheckOutRepository checkOutRepository;
    private BookInterface bookRepository;
    private ReviewRepository reviewRepository;
    public void postBook(AddBookRequest addBookRequest) {
        Book book = new Book();
        book.setTitle(addBookRequest.getTitle());
        book.setAuthor(addBookRequest.getAuthor());
        book.setDescription(addBookRequest.getDescription());
        book.setAvailable_copies(addBookRequest.getCopies());
        book.setCopies(addBookRequest.getCopies());
        book.setImage(addBookRequest.getImg());
        book.setCategory(addBookRequest.getCategory());
        bookRepository.save(book);

    }

    //This is to let people know that there are more books available
    public void IncreaseBookQuantity(Long bookId) throws Exception {
        //If a book can't be found, then we share an error
        Book book = bookRepository.findById(bookId);
        book.setCopies(book.getCopies() + 1);
        book.setAvailable_copies(book.getAvailable_copies() + 1);
        bookRepository.save(book);
    }

    public void DecreaseBookQuantity(Long bookID) throws Exception {
        Book book = bookRepository.findById(bookID);
        if (book.getCopies() == 0 || book.getAvailable_copies() == 0) {
            throw new Exception("Quantity is locked");
        }

        book.setCopies(book.getCopies() - 1);
        book.setAvailable_copies(book.getAvailable_copies() - 1);
    }

    public void DeleteBook(Long bookId) throws Exception {
        Book book = bookRepository.findById(bookId);
        bookRepository.delete(book);
        reviewRepository.deleteAllByBookId(bookId);
        checkOutRepository.deleteAllByBookId(bookId);

    }
}