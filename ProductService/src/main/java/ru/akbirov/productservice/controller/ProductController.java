package ru.akbirov.productservice.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.akbirov.productservice.config.ErrorMessage;
import ru.akbirov.productservice.service.dto.CreateProductDto;
import ru.akbirov.productservice.service.ProductService;

import java.util.Date;
import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody CreateProductDto createProductDto) {

        String productId = null;
        try {
            productId = productService.createProduct(createProductDto);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorMessage(new Date(), e.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(productId);
    }
}
