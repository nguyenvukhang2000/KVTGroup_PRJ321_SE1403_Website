<%-- 
    Document   : LoginFailed
    Created on : July 15, 2020, 11:25:56 AM
    Author     : tú
--%>

    <%@include file="header.jsp" %>

    <section id="form"><!--form-->
        <div class="container">
            <div class="row">

                <div class="alert alert-danger">
                    <strong>${message}</strong> 
                    <p style="cursor: pointer"><a href="index.jsp">Home</a></p>
                </div>

            </div>
        </div>
    </section>
    <%@include file="footer.jsp" %>