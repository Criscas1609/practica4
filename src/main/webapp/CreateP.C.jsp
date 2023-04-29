<%@ page import="com.example.practicaCDI.model.Category" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Cristhian
  Date: 27/04/2023
  Time: 7:41 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <style>
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
<h1>Formulario para agregar un nuevo producto</h1>
<br>
<form method="post" action="${pageContext.request.contextPath}/DatabaseServlet">
    <div>
        <label for="name">Nombre</label>
        <input type="text" id="name" name="name" />
    </div>
    <br>
    <div>
        <label for="price">Precio</label>
        <input type="number" id="price" name="price" />
    </div>
    <br>
    <div>
        <label for="date">Fecha de registro</label><br>
        <input type="date" id="date" name="date" />
    </div>
    <br>
    <div>
        <label for="category">Categoría</label>
        <input type="text" id="category" name="category" />
    </div>
    <button type="submit">Agregar</button>
    <input type="text" name="method" style="visibility: hidden;" value="create">
</form>
</body>
</html>

