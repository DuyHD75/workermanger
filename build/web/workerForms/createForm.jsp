<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Worker | Create new worker</title>
        <style>
            <%@include file="../css/style.css" %>
        </style>
    </head>
    <body>
        <div class="container">
            <h3 class="title">Create Worker</h3>

            <div class="btn-action mb-2">
                <a class="btn btn1" href="/WorkerManagement/workers">List All Workers</a>
            </div>

            <form method="post">
                <table>
                    <tr>
                        <th>Name</th>
                        <td>
                            <input type="text" name="name" id="name" placeholder="Enter your name ...">
                        </td>
                    </tr>
                    <tr>
                        <th>Address</th>
                        <td>
                            <input type="text" name="address" id="address" placeholder="Enter your address ...">
                        </td>
                    </tr>
                    <tr>
                        <th>Email</th>
                        <td>
                            <input type="email" name="email" id="email" placeholder="Enter your email ...">
                        </td>
                    </tr>

                </table>

                <div class="btn-action">
                    <input class="btn btn1" type="submit" value="CREATE">
                </div>
            </form>

            <p>
                <c:if test='${requestScope["message"] != null}'>
                    <span class="message">${requestScope["message"]}</span>
                </c:if>
            </p>

    </body>
</html>
