<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Worker | List all worker</title>
        <style>
            <%@include file="../css/style.css" %>
        </style>
    </head>
    <body>
        <div class="container">

            <h3 class="title">Worker Management</h3>
            <div class="btn-action mb-2">
                <a class="btn btn1" href="/WorkerManagement/workers?action=<%="create"%>"> add new worker</a>
            </div>

            <table>


                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Email</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>

                <c:forEach items='${requestScope["workers"]}' var="worker">
                    <tr>
                        <td>${worker.getId()}</td>
                        <td>${worker.getName()}</td>
                        <td>${worker.getAddress()}</td>
                        <td>${worker.getEmail()}</td>

                        <td>
                            <a href="updateForm.jsp?action=<%="update"%>&id=${worker.getId()}&${worker.getName()}& 
                               &${worker.getAddress()}&${worker.getEmail()}
                               ">Edit</a>
                        </td>
                        <td>
                            <a href="/WorkerManagement/workers?action=<%="delete"%>&id=${worker.getId()}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </body>
</html>
