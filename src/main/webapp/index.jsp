<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Weather Report</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            text-align: center;
            padding: 50px;
        }
        form {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            display: inline-block;
        }
        input[type="text"], input[type="submit"] {
            margin: 10px;
            padding: 10px;
            border-radius: 4px;
            border: 1px solid #ddd;
        }
        input[type="submit"] {
            cursor: pointer;
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body>
<h2>Enter Postal Code to Get Weather</h2>
<form action="weather" method="post">
    <input type="text" id="postalCode" name="postalCode" placeholder="Postal Code"/>
    <input type="submit" value="Get Weather"/>
    <p id="error-message" style="color: red;">${errorMessage}</p>
</form>
</body>
</html>
