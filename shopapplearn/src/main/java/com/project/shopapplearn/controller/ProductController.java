package com.project.shopapplearn.controller;

import com.project.shopapplearn.dtos.ProductDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.yaml.snakeyaml.util.MergeUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    // @Valid: Đảm bảo ProductDTO được kiểm tra tính hợp lệ theo các
    // annotation validation trong class đó (vd: @NotNull, @Size...).
    // BindingResult: Lưu trữ thông tin về lỗi validation nếu có.
    // ResponseEntity: Trả về HTTP response với status code và dữ liệu cụ thể.
    // RequestBody: Lấy dữ liệu từ body của request.
    // MUlTIPART_FORM_DATA_VALUE: Định dạng dữ liệu gửi lên là form data.
    // @RequestPart("file"): Lấy dữ liệu từ phần file gửi lên từ client.
    // MultipartFile: Để xử lý file gửi lên từ client.

    @PostMapping(value = "")
    public ResponseEntity<?> createProducts
            (@Valid @RequestBody ProductDTO productDTO,
             BindingResult result
            ) {
        try {
            if (result.hasErrors()) { // Nếu có lỗi
                List<String> errorMessage = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessage);
            }
            return ResponseEntity.ok("Product created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("")   //http://localhost:8088/api/v1/products?page=1&limit=10
    public ResponseEntity<String> getAllProducts(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit

            //Khi bạn sử dụng @RequestParam("page") và @RequestParam("limit"),
            //bạn đang nhận giá trị của các tham số page và limit từ query string trong URL.
    ) {
        return ResponseEntity.ok("getAllProducts here");
    }


    // @PathVariable("id") String productId
    // id được lấy từ URL (đường dẫn) và ánh xạ vào tham số productId.
    // Dữ liệu này được xử lý như một chuỗi (String), phù hợp khi id có thể là dạng ký tự (chữ cái, số, hoặc kết hợp).
    // Ví dụ, nếu URL là /api/v1/products/ABC123, tham số productId sẽ nhận giá trị "ABC123".
    @PutMapping("/{id}")
    public ResponseEntity<String> getProductById(@PathVariable("id") String productId){
        return ResponseEntity.ok( "Product with id: " +     productId);
    }

    // @PathVariable long id
    //id được lấy từ URL và tự động chuyển đổi thành kiểu số nguyên dài (long).
    //Phù hợp nếu id luôn là một số (ví dụ: 123, 456).
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct (@PathVariable long id){
        return ResponseEntity.ok(String.format("Product with id= %d has been deleted", id));
    }
}
