<%@ page import="com.example.practicaCDI.model.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Cristhian
  Date: 27/04/2023
  Time: 8:06 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
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
        form {
            max-width: 500px;
            margin: 0 auto;
        }
        h1 {
            text-align: center;
            color: #333;
            font-size: 36px;
            font-weight: bold;
            font-family: Arial, sans-serif;
        }
        input[type="text"],
        input[type="number"],
        select {
            display: block;
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 5px;
            border: none;
            box-shadow: 0 2px 5px rgba(0,0,0,0.2);
        }
        button[type="submit"] {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<br>
<h1>Eliminar producto por id</h1>
<br>
<form method="post" action="${pageContext.request.contextPath}/DatabaseServlet">
    <div>
        <label for="id">Id del producto</label>
        <input type="number" id="id" name="id" />
    </div>
    <button type="submit">Eliminar</button>
    <input type="text" style="visibility: hidden;" name="method" value="delete">
</form>
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
</table>
</body>
</html>
