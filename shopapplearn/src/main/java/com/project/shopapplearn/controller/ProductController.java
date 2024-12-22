package com.project.shopapplearn.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @GetMapping("")   //http://localhost:8088//api/v1/products?page=1&limit=10
    public ResponseEntity<String> getAllProducts(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit

            //Khi bạn sử dụng @RequestParam("page") và @RequestParam("limit"),
            //bạn đang nhận giá trị của các tham số page và limit từ query string trong URL.
    ) {
        return ResponseEntity.ok("getAllProducts here");
    }
}
