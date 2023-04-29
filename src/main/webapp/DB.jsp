<%@ page import="com.example.practicaCDI.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.practicaCDI.model.Category" %><%--
  Created by IntelliJ IDEA.
  User: Cristhian
  Date: 26/04/2023
  Time: 7:27 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Agregamos la referencia a Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Tabla de productos</title>
    <style>
        table {
            width: 80%;
            margin: 0 auto;
            border-collapse: collapse;
            background-color: #f9f9f9;
            color: #333;
            font-family: Arial, sans-serif;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: center;
        }

        th {
            background-color: #0d6efd;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .form-box {
            background-color: #f9f9f9;
            border: 1px solid #ccc;
            padding: 20px;
            margin: 20px;
            width: 30%;
            float: left;
        }

        .form-box input {
            width: 100%;
            margin-bottom: 10px;
            padding: 5px;
            box-sizing: border-box;
        }

        .form-box label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        .form-box button[type="submit"] {
            background-color: #0d6efd;
            color: white;
            border: none;
            padding: 10px;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
        }
        h1 {
            text-align: center;
            color: #333;
            font-size: 36px;
            font-weight: bold;
            font-family: Arial, sans-serif;
        }
        .button-container {
            text-align: center;
        }

        button {
            display: inline-block;
            margin: 0 5px;
            max-width: 150px;
        }
    </style>
</head>
<body>
<br><h1>TABLA DE PRODUCTOS</h1><br>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Nombre</th>
        <th>Precio</th>
        <th>Fecha de registro</th>
        <th>Id de categoría</th>
        <th>Nombre de la categoría</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Product> ProductList = (List) request.getSession().getAttribute("productList");
        for (Product product : ProductList) {
    %>
    <tr>
        <td><%=product.getId()%></td>
        <td><%=product.getName()%></td>
        <td><%=product.getPrice()%></td>
        <td><%=product.getRegisterDate()%></td>
        <td><%=product.getCategory().getId()%></td>
        <td><%=product.getCategory().getName()%></td>
    </tr>
    <%}%>
    </tbody>
</table><br>
<h1>TABLA CATEGORÍA</h1>
<br>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Nombre</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Category> categoryList = (List) request.getSession().getAttribute("categoryList");
        for (Category category : categoryList) {
    %>
    <tr>
        <td><%=category.getId()%></td>
        <td><%=category.getName()%></td>
    </tr>
    <%}%>
    </tbody>
</table><br>
<br>
    <div class="button-container">
        <button onclick="window.location.href='CreateP.C.jsp'" class="btn btn-primary">Crear</button>
        <button onclick="window.location.href='Search.jsp'" class="btn btn-primary">Buscar</button>
        <button onclick="window.location.href='Delete.jsp'" class="btn btn-primary">Eliminar</button>
    </div>
<br>
<br>
</body>
</html>

