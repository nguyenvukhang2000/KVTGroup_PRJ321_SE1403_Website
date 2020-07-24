<%-- 
    Document   : ConfirmScratchCard
    Created on : July 15, 2020, 7:55:31 AM
    Author     : tú
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>
<%@include file="slidebar.jsp" %>


<Form action="ConfirmScratchCardServlet" id="ConfirmCardForm" method="POST"><!--form-->
    <div class="container">
        <div class="row">
            <div class="col-xs-9">
                <center><h2 class="title text-center"> Please enter your code </h2>
            <p>your cash VND${LoginUser.uCash}</p>
               <Input type="text" class="input-field" name="CardStr" placeholder="write card code" required="true">
                
                <BR>
                <BR>
                <button type="submit" class="btn btn-default">Submit</button> 
                </center>
            </div>
            
        </div>
    </div>
</Form>

<%@include file="footer.jsp" %>

