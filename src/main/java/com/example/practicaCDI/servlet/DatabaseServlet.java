package com.example.practicaCDI.servlet;
import com.example.practicaCDI.connectionDB.ConexionBD;
import com.example.practicaCDI.model.Category;
import com.example.practicaCDI.model.Product;
import com.example.practicaCDI.service.ProductService;
import com.example.practicaCDI.service.impl.ProductServiceImpl;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DatabaseServlet", value = "/DatabaseServlet")
public class DatabaseServlet extends HttpServlet {
    static List<Product> productList = new ArrayList<>();
    static List<Category> categoryList = new ArrayList<>();

    @Inject
    private ProductService service;
    @Inject
    private Product product;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = req.getSession();
        productList = service.listProducts();
        categoryList = service.listCategory();
        session.setAttribute("productList",productList);
        session.setAttribute("categoryList",categoryList);
        response.sendRedirect("/DB.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if(method.equals("create")){
            create(req, resp);
        }
        if(method.equals("delete")){
            delete(req, resp);
        }
        if(method.equals("search")){
            search(req, resp);
        }
        if(method.equals("update")) {update(req, resp);}

    }


    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        String category = request.getParameter("category");
        service.save(new Product(null,name,date,price,getCategory(category)));
        doGet(request,response);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        service.delete(id);
        doGet(req,resp);
    }
    public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Long id = Long.valueOf(req.getParameter("id"));
        Product product = service.search(id);
        session.setAttribute("product",product);
        resp.sendRedirect("/Search.jsp");
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String name = req.getParameter("name");
        Long id = Long.valueOf(req.getParameter("id"));
        Double price = Double.valueOf(req.getParameter("price"));
        LocalDate date = LocalDate.parse(req.getParameter("date"));
        service.update(id,new Product(null,name,date,price,new Category(null,null)));
        doGet(req,resp);
    }



    public Category getCategory(String name){
        Category category = null;
        for(Category c :categoryList){
            if(c.getName().equals(name)){
                category = c;
            }
        }
     return category;
    }
}
