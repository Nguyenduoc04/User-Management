<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>User List</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">

    <h1 class="text-center mb-4">👤 User Management</h1>

    <div class="d-flex justify-content-between mb-3">

        <a href="users?action=create" class="btn btn-primary">
            <i class="bi bi-plus-circle"></i> Create User
        </a>

        <a href="users?action=sort" class="btn btn-success">
            <i class="bi bi-sort-alpha-down"></i> Sort by Name
        </a>

    </div>

    <form action="users" method="get" class="d-flex mb-3">
        <input type="hidden" name="action" value="search">
        <input type="text" name="country" class="form-control me-2" placeholder="Search by country">
        <button type="submit" class="btn btn-dark">
            <i class="bi bi-search"></i>
        </button>
    </form>

    <table class="table table-bordered table-hover bg-white shadow">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Action</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.country}</td>
                <td>
                    <a href="users?action=view&id=${user.id}" class="btn btn-info btn-sm">
                        <i class="bi bi-eye"></i>
                    </a>

                    <a href="users?action=edit&id=${user.id}" class="btn btn-warning btn-sm">
                        <i class="bi bi-pencil"></i>
                    </a>

                    <a href="users?action=delete&id=${user.id}" class="btn btn-danger btn-sm"
                       onclick="return confirm('Are you sure?')">
                        <i class="bi bi-trash"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

</div>

</body>
</html>