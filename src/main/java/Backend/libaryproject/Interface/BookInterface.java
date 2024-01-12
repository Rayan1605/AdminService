package Backend.libaryproject.Interface;

import Backend.libaryproject.Entity.Checkout;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Book-service",url = "https://localhost:8081")
public interface BookInterface {

    @PostMapping("/save")
    void save(@RequestBody Backend.libaryproject.Entity.Book book);

    @GetMapping("/FindID")
    Backend.libaryproject.Entity.Book findById(Long id);

    @PostMapping("/Delete")
    void delete(@RequestBody Backend.libaryproject.Entity.Book book);




}
