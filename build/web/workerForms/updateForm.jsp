<%-- 
    Document   : updateForm
    Created on : Feb 22, 2023, 7:34:06 AM
    Author     : This PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Worker | Update worker </title>
        <style>
            <%@include file="../css/style.css" %>
        </style>
    </head>
    <body>
        <div class="container">
            <h3 class="title">Update worker</h3>
            <div class="btn-action mb-2">
                <a class="btn btn1" href="/WorkerManagement/workers">List All Workers</a>
            </div>

            <form method="post">
                <table>
                    <c:if test="${worker != null}">
                        <input type="hidden" name="id" value="<c:out value="${worker.getId()}"/>">
                    </c:if>

                    <tr>
                        <th>Name</th>
                        <td>
                            <input type="text" name="name" value="${worker.getName()}">
                        </td>
                    </tr>
                    <tr>
                        <th>Address</th>
                        <td>
                            <input type="text" name="address" value="${worker.getAddress()}">

                        </td>
                    </tr>
                    <tr>
                        <th>Email</th>
                        <td>
                            <input type="email" name="email" value="${worker.getEmail()}">
                        </td>
                    </tr>
                </table>
                <div class="btn-action">
                    <input class="btn btn1" type="submit" value="EDIT">
                </div>
            </form>

                        
            <p>
            <c:if test='${requestScope["message"] != null}'>
                <span class="message">${requestScope["message"]}</span>
            </c:if>
        </p>

    </div>
</body>
</html>
