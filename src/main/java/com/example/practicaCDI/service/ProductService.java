package com.example.practicaCDI.service;

import com.example.practicaCDI.model.Category;
import com.example.practicaCDI.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> listProducts();
    List<Category> listCategory();
    void save(Product product);
    void delete(Long id);
    Product search(Long id);
    void update(Long id, Product product);
}
