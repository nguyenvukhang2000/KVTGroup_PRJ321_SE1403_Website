<%-- 
    Document   : addcards
    Created on : Jul 22, 2020, 2:02:26 PM
    Author     : vinhhqce140143
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include  file="Header.jsp" %>

<%@include  file="Slidebar.jsp" %>
<div class="col-sm-6 padding-right">
    <h3 color="#fe980f">New Card</h3>
    <div class="table-responsive cart_info">
        <form action="ChargeCards" method="get"> 
            <div class="product-information"
                <label>Cards</label>
                <select name="cards">
                    <option> 50000 </option>
                    <option>100000</option>
                    <option>200000</option>
                    <option>500000</option>
                </select>
                <label>Number Of Cards</label>
                <input type="number" name="numberofcard" placeholder="enter number" required min="1" class="input-field"/>
                <input type="submit" value="Add"  class="btn btn-default"/>
            </div>
        </form>
    </div>
</div>
<%@include  file="Footer.jsp" %>


