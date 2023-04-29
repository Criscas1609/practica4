package com.example.practicaCDI.repository.impl;

import com.example.practicaCDI.model.Category;
import com.example.practicaCDI.model.Product;
import com.example.practicaCDI.repository.CrudRepository;
import com.example.practicaCDI.repository.Repository;
import jakarta.inject.Inject;

import javax.naming.NamingException;
import java.lang.annotation.Annotation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.practicaCDI.connectionDB.ConexionBD.getConnection;
@Repository
public class CategoryRepositoryImpl implements CrudRepository<Category> {
    @Override
    public List<Category> list() {
        List<Category> categories = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM category")) {
            while (rs.next()) {
                Category p = createCategory(rs);
                categories.add(p);
            }
        } catch (NamingException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }

    @Override
    public List<Category> listar() {
        return null;
    }

    @Override
    public Category byId(Long id) {
        return null;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Long id, Product product) {

    }


    private Category createCategory(ResultSet resultSet) throws
            SQLException {
        Category category = new Category();
        category.setId(resultSet.getLong("id"));
        category.setName(resultSet.getString("nombre"));

        return category;
    }

}
