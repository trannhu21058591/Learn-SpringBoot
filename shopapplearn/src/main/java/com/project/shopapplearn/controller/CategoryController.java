package com.project.shopapplearn.controller;

import com.project.shopapplearn.dtos.CategoryDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")

public class CategoryController {
    //Hien thi tat ca category
    @GetMapping("")  //http://localhost:8088/api/v1/categories?page=1&limit=10
    public ResponseEntity<String> getAllCategories(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit

            //Khi bạn sử dụng @RequestParam("page") và @RequestParam("limit"),
            //bạn đang nhận giá trị của các tham số page và limit từ query string trong URL.
    ) {
        return ResponseEntity.ok(String.format("Danh sach category, page = %d, limit = %d", page, limit));
    }

    //Nếu hằng số truyền vào là 1 object (đối tượng) thì sao?
    //      => Data Transfer Object = Request Object
    @PostMapping("")
    public ResponseEntity<?> insertCatogory(@Valid @RequestBody CategoryDTO categoryDTO, BindingResult result) {
        if (result.hasErrors()) { // Nếu có lỗi
            List<String> errorMessage = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errorMessage);
        }
        return ResponseEntity.ok("Tao moi category " + categoryDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id) {
        return ResponseEntity.ok("Cap nhat category = " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        return ResponseEntity.ok("Xoa category =" + id);
    }
}
