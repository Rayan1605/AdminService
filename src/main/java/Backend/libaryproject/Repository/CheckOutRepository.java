package Backend.libaryproject.Repository;

import Backend.libaryproject.Entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CheckOutRepository extends JpaRepository<Checkout, Long> {

@Modifying
@Query("delete from Checkout where bookId = :book_id")
    void deleteAllByBookId(@Param("book_id") Long bookId);
}
