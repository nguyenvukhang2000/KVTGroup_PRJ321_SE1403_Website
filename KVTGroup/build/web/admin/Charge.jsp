<%-- 
    Document   : Charge
    Created on : Jul 17, 2020, 3:15:51 PM
    Author     : vinhhqce140143
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include  file="Header.jsp" %>

<%@include  file="Slidebar.jsp" %>
<jsp:include page="ChargeServlet"/>
<div class="col-sm-9 padding-right">
    <h2>Scratch Card
        <a class="btn btn-default" style="float: right;" href="addcards.jsp">New Card</a>
    </h2>
    <div class="table-responsive cart_info">
        <table class="table table-condensed">
            <thead>
                <tr class="cart_menu">
                    <td class="image">Cards</td>
                    <td class="cart_description"> Number Of Cards Available</td>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="cart_product">
                        <p>50000VND</p>
                    </td>
                    <td class="cart_description">
                        <p>${requestScope.SumCard50}</p>
                    </td>
                </tr>
                <tr>
                    <td class="cart_product">
                        <p>100000VND</p>
                    </td>
                    <td class="cart_description">
                        <p>${requestScope.SumCard100}</p>

                    </td>
                </tr>
                <tr>
                    <td class="cart_product">
                        <p>200000VND</p>
                    </td>
                    <td class="cart_description">
                        <p>${requestScope.SumCard200}</p>

                    </td>
                </tr>
                <tr>
                    <td class="cart_product">
                        <p>500000VND</p>
                    </td>
                    <td class="cart_description">
                        <p>${requestScope.SumCard500}</p>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
<%@include file="Footer.jsp" %>
<%@include file="Notify.jsp" %>

