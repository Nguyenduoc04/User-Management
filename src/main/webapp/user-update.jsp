<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Update User</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body style="background: linear-gradient(to right, #ffecd2, #fcb69f);">

<div class="container mt-5">
    <div class="card shadow-lg p-4 mx-auto" style="max-width: 500px;">

        <h3 class="text-center mb-4">✏️ Update User</h3>

        <form action="users?action=edit" method="post">
            <input type="hidden" name="id" value="${user.id}">

            <div class="mb-3">
                <label class="form-label">Name</label>
                <input type="text" name="name" value="${user.name}" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Email</label>
                <input type="email" name="email" value="${user.email}" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Country</label>
                <select name="country" class="form-select" required>
                    <c:forEach items="${countries}" var="c">
                        <option value="${c}"
                                <c:if test="${c.equals(user.country)}">selected</c:if>>
                                ${c}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="d-flex justify-content-between">
                <a href="users" class="btn btn-secondary">⬅ Back</a>
                <button type="submit" class="btn btn-warning">Update</button>
            </div>

        </form>

    </div>
</div>

</body>
</html>