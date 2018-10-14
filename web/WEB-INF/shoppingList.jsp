<%-- 
    Document   : shoppingList
    Created on : 9-Oct-2018, 12:47:13 PM
    Author     : Mason
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        Hello, ${username} <a href="ShoppingList?logout">Logout</a><br>
        
        <form method="post" action="ShoppingList">
            <h2>List</h2>
            Add Item:<input type="text" name="additem">
            <input type="submit" value="Add" name="action">
            <br>
        </form>
                
        <form method="post" action="ShoppingList">
            <c:forEach var="item" items="${items}">
                <input type="radio" name="shopping_item" value="${item}">${item}<br>
            </c:forEach>
                
            <input type="submit" value="Delete" name="action">       
        </form>
    </body>
</html>
