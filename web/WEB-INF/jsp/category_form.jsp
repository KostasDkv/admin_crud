<%-- 
    Document   : product_form
    Created on : 12 Απρ 2018, 2:20:06 πμ
    Author     : user
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Category Form</title>
    </head>
    <body>
        <h1>Category Form</h1>
        
        <form:form 
            
            method="POST"
            modelAttribute="category"
            action="${pageContext.request.contextPath}/admin/insert_category" >
            
            <form:label path="categoryName">Category Name: </form:label>
            <form:errors path="categoryName"/>
            <form:input path="categoryName"/>

            <input type="submit" value="Insert Category">
            
        </form:form>
        
    </body>
</html>
