package ru.akbirov.productservice.service;

import ru.akbirov.productservice.service.dto.CreateProductDto;

import java.util.concurrent.ExecutionException;

public interface ProductService {

    String createProduct(CreateProductDto createProductDto) throws ExecutionException, InterruptedException;

}
