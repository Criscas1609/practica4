package com.example.practicaCDI.repository;

import com.example.practicaCDI.model.Product;

import java.util.List;

public interface CrudRepository<T> {
    List<T> list();
    List<T> listar();
    T byId(Long id);
    void save(Product product);
    void delete(Long id);
    void update(Long id, Product product);
}
