<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 5/20/2024
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
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
            <a href="" class="navbar-brand">User Management App</a>
        </div>
        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Employee</a> </li>
        </ul>
    </nav>
</header>
<div class="row">
    <div class="container col-md-5">
        <div class="card">
            <div class="card-body">
                <c:if test="${employee != null}">
                <form action="insert" method="post">
                    </c:if>
                    <c:if test="${user != null}">
                        <input type="hidden" name="id" value="<c:out value='${employee.id}' />">
                    </c:if>
                    <fieldset class="form-group">
                        <label>Employee Name</label>
                        <input type="text" value="<c:out value='${employee.fullName}' /> " class="form-control" name="name" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Birthday</label>
                        <input type="text" value="<c:out value='${employee.birthday}' /> " class="form-control" name="birthday">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Address</label>
                        <input type="text" value="<c:out value='${user.address}' /> " class="form-control" name="address">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Position</label>
                        <input type="text" value="<c:out value='${user.Position}' /> " class="form-control" name="Position">
                    </fieldset>


                    <fieldset class="form-group">
                        <label>Department</label>
                        <input type="text" value="<c:out value='${user.Department}' /> " class="form-control" name="Department">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>

</html>
