package com.example.practicaCDI.service.impl;

import com.example.practicaCDI.exception.ServiceJdbcException;
import com.example.practicaCDI.model.Category;
import com.example.practicaCDI.model.Product;
import com.example.practicaCDI.repository.CrudRepository;
import com.example.practicaCDI.repository.Repository;
import com.example.practicaCDI.repository.impl.CategoryRepositoryImpl;
import com.example.practicaCDI.repository.impl.ProductRepositoryImpl;
import com.example.practicaCDI.service.ProductService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
@ApplicationScoped
public class ProductServiceImpl implements ProductService {
    private CrudRepository<Product> productRepository = new ProductRepositoryImpl();
    private CrudRepository<Category> categoryRepository = new CategoryRepositoryImpl();


    public List<Product> listProducts() {
        return productRepository.listar();
    }

    public List<Category> listCategory() {
        return categoryRepository.list();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.delete(id);
    }

    public Product search(Long id) {
        return productRepository.byId(id);
    }

    public void update(Long id, Product product){
        productRepository.update(id, product);
    }

}
