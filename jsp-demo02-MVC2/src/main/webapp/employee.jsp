<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 5/20/2024
  Time: 11:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="">
        <div>
            <a href="" class="navbar-brand">Employee Management App</a>
        </div>
        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Employees</a> </li>
        </ul>
    </nav>
</header>
<br>
<div class="row">
    <div class="container">
        <h3 class="text-center">List Of Users </h3>
        <hr>
        <div class="container text-left">
            <a href="<%=request.getContextPath()%>/new">Add new Employee</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Full Name</th>
                <th>Birthday</th>
                <th>address</th>
                <th>Position</th>
                <th>Department</th>
                <th>Option</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="employee" item="${employee}">
                <tr>
                    <td>
                        <c:out value="${employee.id}" />
                    </td>
                    <td>
                        <c:out value="${employee.fullName}" />
                    </td>
                    <td>
                        <c:out value="${employee.birthday}" />
                    </td>
                    <td>
                        <c:out value="${employee.address}" />
                    </td>
                    <td>
                        <a href="edit?id=<c:out value='${employee.id}'/> ">Edit</a>
                        <a href="delete?id=<c:out value='${employee.id}'/> ">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            <!-- } -->
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
