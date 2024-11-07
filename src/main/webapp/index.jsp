<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>SQL Query Executor</title>
</head>
<body>
    <h2>SQL-запити для таблиць Street, Building, Apartment</h2>
    
    <!-- Форма для таблиці Street -->
    <h3>Street</h3>
    <form action="ExecuteQueryServlet" method="POST">
        <input type="hidden" name="table" value="street">
        <textarea name="query" rows="4" cols="50" placeholder="Наприклад: SELECT * FROM street;"></textarea><br><br>
        <input type="submit" value="Виконати запит">
    </form>

    <!-- Форма для таблиці Building -->
    <h3>Building</h3>
    <form action="ExecuteQueryServlet" method="POST">
        <input type="hidden" name="table" value="building">
        <textarea name="query" rows="4" cols="50" placeholder="Наприклад: SELECT * FROM building;"></textarea><br><br>
        <input type="submit" value="Виконати запит">
    </form>

    <!-- Форма для таблиці Apartment -->
    <h3>Apartment</h3>
    <form action="ExecuteQueryServlet" method="POST">
        <input type="hidden" name="table" value="apartment">
        <textarea name="query" rows="4" cols="50" placeholder="Наприклад: SELECT * FROM apartment;"></textarea><br><br>
        <input type="submit" value="Виконати запит">
    </form>

    <!-- Вивід результатів -->
    <div id="results">
        <h3>Результат запиту:</h3>
        ${queryResult} <!-- Виведення результату виконання запиту -->
    </div>
</body>
</html>
