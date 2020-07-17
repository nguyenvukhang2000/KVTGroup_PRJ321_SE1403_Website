<%-- 
    Document   : Products
    Created on : Jul 17, 2020, 1:03:57 PM
    Author     : vinhhqce140143
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="Header.jsp" %>

<%@include  file="Slidebar.jsp" %>
        <div class="col-sm-9 padding-right">
            <h2>
                Products
            </h2>
            <div class="table-responsive cart_info">
                <table class="table table-condensed">
                    <thead>
                        <tr class="cart_menu">
                            <td class="image">Item</td>
                            <td class="description"></td>
                            <td class="price">Price</td>
                            <td class="quantity">Quantity</td>
                            <td></td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${!empty requestScope.listOfProducts}">
                            <c:forEach items="${requestScope.listOfProducts}" var="product">
                                <tr>
                                    <td class="cart_product">
                                        <a href=""><img src="../${product.pImage}" alt=""/></a>
                                    </td>
                                    <td class="cart_description">
                                        <p>${product.pName}</p>
                                    </td>
                                    <td class="cart_price">
                                        <h4>$${product.pPrice}</h4>
                                    </td>
                                    <td class="cart_quantity">
                                        <p>${product.pQuantity}</p>
                                    </td>
                                    <td class="cart_delete">
                                        <a class="cart_quantity_delete" href="DeleteProduct?pId=${product.pId}"><i class="fa fa-times"></i></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    <%@include file="Footer.jsp" %>
    <%@include file="Notify.jsp" %>
