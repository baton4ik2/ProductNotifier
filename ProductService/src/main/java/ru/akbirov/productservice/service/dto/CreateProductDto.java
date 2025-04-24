package ru.akbirov.productservice.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductDto {

    private String title;
    private BigDecimal price;
    private Integer quantity;
}
