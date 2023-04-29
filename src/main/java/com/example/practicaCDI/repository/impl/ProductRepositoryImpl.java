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
public class ProductRepositoryImpl implements CrudRepository<Product> {


    public List<Product> listar() {
        List<Product> productList = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
             ResultSet rs = stmt.executeQuery("SELECT p.*,c.nombre as categoria_nombre from products as p" +
                     " inner join category as c ON (p.categoria_id=c.id)" +
                     " order by p.id ASC")) {
            while (rs.next()) {
            Product p = createProduct(rs);
            productList.add(p);
        }
    } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }



    private Product createProduct(ResultSet resultSet) throws
            SQLException {
        Product producto = new Product();
        producto.setId(resultSet.getLong("id"));

        producto.setName(resultSet.getString("nombre"));
        producto.setPrice(resultSet.getDouble("precio"));
        producto.setRegisterDate(resultSet.getDate("fecha_registro").toLocalDate());
        Category categoria = new Category();
        categoria.setId(resultSet.getLong("categoria_id"));
        categoria.setName(resultSet.getString("categoria_nombre"));
        producto.setCategory(categoria);
        return producto;
    }

    public List<Product> list() {
        List<Product> productList = new ArrayList<>();
        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT p.*,c.nombre as categoria_nombre from products as p inner join category as c ON (p.categoria_id=c.id)")) {
            while (resultSet.next()) {
                Product producto = createProduct(resultSet);
                productList.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    public Product byId(Long id) {
        Product producto = null;
        try (PreparedStatement preparedStatement = getConnection()
                .prepareStatement("SELECT p.*,c.nombre as categoria_nombre from products as p inner join category as c ON (p.categoria_id=c.id) WHERE p.id=?")) {
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                producto = createProduct(resultSet);
            }else {
                System.out.println("No existe ese id");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return producto;
    }


    public void save(Product product) {
        try (PreparedStatement preparedStatement=getConnection().prepareStatement("INSERT INTO products(nombre,precio,fecha_registro,categoria_id) VALUES (?,?,?,?)")){
            preparedStatement.setString(1,product.getName());
            preparedStatement.setLong(2,product.getPrice().longValue());
            preparedStatement.setDate(3,Date.valueOf(product.getRegisterDate()));
            preparedStatement.setLong(4,product.getCategory().getId());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void delete(Long valueId) {
        System.out.printf(String.valueOf(valueId));
        try {
            PreparedStatement preparedStatement = getConnection()
                    .prepareStatement("DELETE FROM products WHERE id ='"+valueId+"'");
                preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Long id, Product product) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("UPDATE products SET nombre=? ,precio=?,fecha_registro=? where id='"+id+"'")) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setLong(2, product.getPrice().longValue());
            preparedStatement.setDate(3, Date.valueOf(product.getRegisterDate()));
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
