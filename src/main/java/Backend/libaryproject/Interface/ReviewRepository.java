package Backend.libaryproject.Interface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "confirmation-service",url = "https://localhost:8085")
public interface ReviewRepository {
    @PostMapping("/FindID")
    void deleteAllByBookId(@Param("book_id") Long bookId);

}
