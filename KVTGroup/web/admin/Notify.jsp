<%-- 
    Document   : Notify
    Created on : Jul 17, 2020, 2:28:09 PM
    Author     : vinhhqce140143
--%>
<c:if test="${not empty AlertMessage}">
    <script>showNotification('${AlertMessage}','${AlertType}');</script>
    <c:remove var="AlertMessage" scope="session" />
</c:if>
