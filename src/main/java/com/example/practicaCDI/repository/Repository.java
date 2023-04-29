package com.example.practicaCDI.repository;


import com.example.practicaCDI.model.Product;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Stereotype;
import jakarta.inject.Named;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.sql.SQLException;
import java.util.List;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@RequestScoped
@Named
@Stereotype
@Retention(RUNTIME)
@Target(ElementType.TYPE)
public @interface Repository {
    /*List<T> list();
    List<T> listar();
    T byId(Long id);
    void save(Product product);
    void delete(Long id);
    void update(Long id, Product product);*/


}
