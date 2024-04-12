<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../../../../resources/templates/Shared/Header.Html"%>

<div  class="container">
    <h1>User List</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Img Path</th>
            <th>Email</th>
            <th>Password</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${empty UserList}">
                <tr>
                    <td colspan="6">No users found.</td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach items="${UserList}" var="user">
                    <tr>
                        <td>${user.idU}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.imgPath}</td>
                        <td>${user.email}</td>
                        <td>${user.password}</td>
                        <td><a class="btn btn-success " href="editUser?id=${user.idU}">Edit</a>
                            <a class="btn btn-danger" href="deleteUser?id=${user.idU}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
</div>
<%@ include file="../../../../resources/templates/Shared/Footer.html"%>
