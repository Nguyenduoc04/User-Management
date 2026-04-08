<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>User Detail</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body style="background: linear-gradient(to right, #a1c4fd, #c2e9fb);">

<div class="container mt-5">
    <div class="card shadow-lg p-4 mx-auto" style="max-width: 500px;">

        <h3 class="text-center mb-4">👤 User Detail</h3>

        <ul class="list-group mb-3">
            <li class="list-group-item"><b>ID:</b> ${user.id}</li>
            <li class="list-group-item"><b>Name:</b> ${user.name}</li>
            <li class="list-group-item"><b>Email:</b> ${user.email}</li>
            <li class="list-group-item"><b>Country:</b> ${user.country}</li>
        </ul>

        <div class="text-center">
            <a href="users" class="btn btn-primary">⬅ Back to List</a>
        </div>

    </div>
</div>

</body>
</html>