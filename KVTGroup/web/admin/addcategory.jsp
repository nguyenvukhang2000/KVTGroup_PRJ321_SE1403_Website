<%-- 
    Document   : addcategory
    Created on : Jul 19, 2020, 10:54:10 PM
    Author     : vinhhqce140143
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="Header.jsp" %>

<%@include file="Slidebar.jsp" %>
<div class="col-sm-8">
    <div class="product-information"><!--/product-information-->
        <form action="AdminCategory" method="post" >
            <h2>Add Category</h2>
            <label>Category Name</label>
            <input type="text" placeholder="Category Name" name="CategoryName"  class="input-field" id="ProductName" required/>
            <button type="submit" class="btn btn-default">Add Category </button>
        </form>
    </div>
</div>
<%@include file="Footer.jsp" %>

