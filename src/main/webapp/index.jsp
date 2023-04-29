<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Index</title>
    <style>
        body {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        h1 {
            font-size: 32px;
            margin-bottom: 40px;
            text-align: center;
        }
        h2 {
             font-size: 32px;
             margin-bottom: 40px;
             text-align: center;
         }

        button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 10px;
        }

        #login-btn {
            background-color: #2196F3;
        }

        #links-btn {
            background-color: #f44336;
        }
    </style>
</head>
<body>
<h1>Bienvenid@ entre a la base de datos</h1>
<form method="get" action="${pageContext.request.contextPath}/DatabaseServlet">
<button id="login-btn" type="submit" >Base de datos</button>
</form>

</body>
</html>