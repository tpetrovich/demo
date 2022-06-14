package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {
    ProductDTO add(Product product);

    ProductDTO update(Product product);

    void delete(Long id);

    ProductDTO detail(Long id);

    List<ProductDTO> list();
}
