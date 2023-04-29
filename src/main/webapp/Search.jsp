<%--
  Created by IntelliJ IDEA.
  User: Cristhian
  Date: 27/04/2023
  Time: 8:06 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<h1>Buscar producto por id</h1>
<br>
<form method="post" action="${pageContext.request.contextPath}/DatabaseServlet">
    <div>
        <label for="id">Id del producto</label>
        <input type="number" id="id" name="id" />
    </div>
    <button type="submit">Buscar</button>
    <input type="text" style="visibility: hidden;" name="method" value="search">
</form>
<form method="get" action="${pageContext.request.contextPath}/DatabaseServlet">
    <button type="submit">Volver</button>
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
        Product product = (Product) request.getSession().getAttribute("product");
        if(product!=null){
    %>
    <tr>
        <td><%=product.getId()%></td>
        <td><%=product.getName()%></td>
        <td><%=product.getPrice()%></td>
        <td><%=product.getRegisterDate()%></td>
        <td><%=product.getCategory().getId()%></td>
        <td><%=product.getCategory().getName()%></td>
    </tr>
    </tbody>
</table><br>
<br><form method="post" action="${pageContext.request.contextPath}/DatabaseServlet">
    <div>
        <label for="name">Nombre</label>
        <input type="text" id="name" name="name" value="<%=product.getName()%>" />
    </div>
    <br>
    <div>
        <label for="price">Precio</label>
        <input type="number" id="price" name="price" value="<%=product.getPrice()%>" />
    </div>
    <br>
    <div>
        <label for="date">Fecha de registro</label>
        <input type="date" id="date" name="date" value="<%=product.getRegisterDate()%>" />
    </div>
    <br>

    <button type="submit">Actualizar</button>
    <input type="text" name="method" style="visibility: hidden;" value="update">
    <input type="text" name="id" style="visibility: hidden;" value="<%=product.getId()%>">

</form>
<%}%>
</body>
</html>
